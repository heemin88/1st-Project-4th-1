package com.backend.back.api.controller;


import com.backend.back.domain.board.Board;
import com.backend.back.domain.comment.Comment;
import com.backend.back.domain.user.User;
import com.backend.back.api.ResponseDto;
import com.backend.back.api.dto.comment.CommentDeleteRequest;
import com.backend.back.api.dto.comment.CommentModifyRequest;
import com.backend.back.api.dto.comment.CommentRequest;
import com.backend.back.service.BoardService;
import com.backend.back.service.CommentService;
import com.backend.back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/comment")
public class CommentApiController {

    private final CommentService commentService;

    private final UserService userService;
    private final BoardService boardService;

    /**
     * 댓글 작성
     */

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> registerComment(@Validated @RequestBody CommentRequest request,
                                                       BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResponseEntity.ok().body(new ResponseDto("다시 입력해주세요."));
        }

        User one = userService.findOne(request.getToken());
        Board board_byId = boardService.findBoard_byId(request.getBoardId());
        Comment comment=new Comment(request.getDescription(), LocalDateTime.now());

        commentService.write_Comment(one,board_byId,comment);

        return ResponseEntity.ok().body(new ResponseDto("댓글을 작성 하였습니다."));
    }

    /**
     *
     * 댓글 수정
     */
    @PutMapping("/modify")
    public ResponseEntity<ResponseDto> modifyComment(@Validated @RequestBody CommentModifyRequest request,
                                                     BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()) {
            return ResponseEntity.ok().body(new ResponseDto("다시 입력헤주세요"));
        }

        commentService.modify_Comment(request.getCommentId(),request);

        return ResponseEntity.ok().body(new ResponseDto("수정이 완료 되었습니다."));
    }

    /**
     *
     * 댓글 삭제
     */
    @PostMapping("/delete")
    public ResponseEntity<ResponseDto> deleteBoard(@RequestBody CommentDeleteRequest request) throws IOException {

        Comment comment = commentService.findOne(request.getCommentId());
        User user = userService.findOne(request.getToken());
        Board board_byId = boardService.findBoard_byId(request.getBoardId());

        commentService.delete_Comment(user,board_byId,comment);

        return ResponseEntity.ok().body(new ResponseDto("게시물이 삭제 되었습니다."));
    }


}
