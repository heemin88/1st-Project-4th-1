package com.backend.back.api.Controller;


import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.user.User;
import com.backend.back.api.ResponseDto;
import com.backend.back.api.dto.BoardDeleteRequest;
import com.backend.back.api.dto.BoardModifyRequest;
import com.backend.back.api.dto.BoardRequest;
import com.backend.back.api.dto.BoardResponse;
import com.backend.back.service.BoardService;
import com.backend.back.service.UserService;
import jdk.jfr.Frequency;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/board")
public class BoardApiController {

    private final UserService userService;
    private final BoardService boardService;


    /**
     * 게시물 등록
     */
    
    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerBoard(@Validated @RequestBody BoardRequest request,
                                                     BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new ResponseDto("정보를 다시 입력해주세요"));
        }
        String token = request.getToken();
        User one = userService.findOne(token);
        Board board = request.to_Entity();
        boardService.register_Board(one,board);

        return ResponseEntity.ok(new ResponseDto("게시물을 등록하였습니다."));
    }

    /**
     *
     * 게시물 전체 조회
     */
    @GetMapping
    public ResponseEntity<List<BoardResponse>> getBoardList() {
        List<Board> all = boardService.findAll();
        List<BoardResponse> boardResponseList = all.stream().map(BoardResponse::toDto).collect(Collectors.toList());
        return ResponseEntity.ok().body(boardResponseList);
    }

    /**
     *
     * 게시물 단건 조회
     */

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getBoard(@PathVariable("id") Long id) {
        Board board_byId = boardService.findBoard_byId(id);

        return ResponseEntity.ok().body(new BoardResponse(board_byId));
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<ResponseDto> modifyBoard(@PathVariable("id") Long id,
                                                   @Validated @RequestBody BoardModifyRequest request,
                                                   BindingResult bindingResult) throws IOException {

        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new ResponseDto("정보를 다시 입력하세요."));
        }

        boardService.updateBoard(id,request);
        return ResponseEntity.ok().body(new ResponseDto("수정이 완료 되었습니다."));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteBoard(@PathVariable("id") Long id,
                                                   @RequestBody BoardDeleteRequest request) {
        Board board_byId = boardService.findBoard_byId(id);
        boardService.delete_Board(board_byId,request);

        return ResponseEntity.ok().body(new ResponseDto("게시물이 삭제 되었습니다."));
    }


}
