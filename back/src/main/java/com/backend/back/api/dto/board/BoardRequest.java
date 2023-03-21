package com.backend.back.api.dto.board;

import com.backend.back.domain.board.Board;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardRequest {

    private String token;
    @NotBlank(message="게시글의 제목을 입력하세요.")
    private String title;

    @NotBlank(message=" 내용을 작성하세요 ")
    private String description;

    public Board to_Entity() {
        Board board=new Board();
        board.setTitle(title);
        board.setDescription(description);
        board.setCreated_date(LocalDateTime.now());

        return board;
    }
}
