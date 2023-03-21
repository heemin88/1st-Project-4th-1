package com.backend.back.repository;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    Board findBoardById(Long id);
    List<Board> findBoardsByUser(User user);
}
