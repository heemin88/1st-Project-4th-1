package com.backend.back.repository;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.comment.Comment;
import com.backend.back.Domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    Comment findCommentById(Long id);

    List<Comment> findCommentsByBoard(Board board);
    List<Comment> findCommentsByUser(User user);
}
