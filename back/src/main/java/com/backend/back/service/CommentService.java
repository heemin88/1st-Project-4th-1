package com.backend.back.service;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.comment.Comment;
import com.backend.back.Domain.user.User;
import com.backend.back.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    /**
     *
     *
     * 댓글 작성 Service
     */
    public void write_Comment(User user, Board board, Comment comment) {

        comment.setUser(user);
        comment.setBoard(board);

        List<Comment> commentList = board.getCommentList();
        commentList.add(comment);

        List<Comment> comments = user.getComments();
        comments.add(comment);

        commentRepository.save(comment);
    }

    /**
     *
     *
     * 댓글 삭제 Service
     */
    public void delete_Comment(User user,Board board,Comment comment) {

        List<Comment> comments = user.getComments();
        comments.remove(comment);

        List<Comment> commentList = board.getCommentList();
        commentList.remove(comment);

        commentRepository.delete(comment);
    }

    /**
     * 공통 Service
     */

    public List<Comment> find_boardComment(Board board) {
        return commentRepository.findCommentsByBoard(board);
    }

    public List<Comment> find_userComment(User user) {
        return commentRepository.findCommentsByUser(user);
    }


}
