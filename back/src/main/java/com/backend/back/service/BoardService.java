package com.backend.back.service;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.comment.Comment;
import com.backend.back.Domain.user.User;
import com.backend.back.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     *
     *
     * 게시물 등록 Service
     */
    @Transactional
    public  Long register_Board(User user,Board board) {
        board.setUser(user);
        List<Board> posts = user.getPosts();
        posts.add(board);

        boardRepository.save(board);

        return board.getId();
    }


    /**
     *
     * 게시물 삭제 Service
     */
    public void delete_Board(Board board) {
        List<Comment> commentList = board.getCommentList();
        commentList.clear();;

        User user = board.getUser();
        List<Board> posts = user.getPosts();
        posts.remove(board);

        boardRepository.delete(board);
    }


    /**
     *
     *
     * 공통 Service
     */

    public List<Board> findBoard_byUser(User user) {
        return boardRepository.findBoardsByUser(user);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findBoard_byId(Long id) {
        return boardRepository.findBoardById(id);
    }


}
