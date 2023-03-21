package com.backend.back.api.dto.board;

import com.backend.back.domain.board.Board;
import lombok.Data;

@Data
public class BoardResponse {

    private String title;

    private String description;

    private Integer view_count;

    public BoardResponse(Board board) {
        this.title = board.getTitle();
        this.description = board.getDescription();
        this.view_count = board.getView_count();
    }


    public static BoardResponse toDto(Board board) {
        return new BoardResponse(board);
    }
}
