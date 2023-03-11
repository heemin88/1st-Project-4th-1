package com.backend.back.service;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    public void 게시물등록() throws Exception {
        User user=new User("hys3396","1234","1",3);
        Board board=new Board(user,"hello","gg", LocalDateTime.now(),LocalDateTime.now(),0);
        boardService.register_Board(user,board);
    }

}