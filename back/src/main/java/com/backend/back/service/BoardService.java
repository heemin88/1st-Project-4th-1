package com.backend.back.service;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.user.User;
import com.backend.back.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public  Long register_Board(User user,Board board) {
        board.setUser(user);
        boardRepository.save(board);

        return board.getId();
    }
}
