package com.backend.back.api.dto.comment;

import lombok.Data;

@Data
public class CommentDeleteRequest {

    private String token;
    private Long commentId;
    private Long boardId;
}
