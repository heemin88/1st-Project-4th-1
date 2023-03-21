package com.backend.back.api.dto;

import com.backend.back.Domain.board.Board;
import lombok.Data;

@Data
public class BoardResponse {

    private String title;

    private String description;

    private Integer view_count;

    public BoardResponse(Board board) {
        this.title = title;
        this.description = description;
        this.view_count = view_count;
    }

    public static BoardResponse toDto(Board board) {
        return new BoardResponse(board);
    }
}
