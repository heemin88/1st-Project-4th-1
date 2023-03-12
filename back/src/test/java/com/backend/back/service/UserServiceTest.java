package com.backend.back.service;

import com.backend.back.BackApplication;
import com.backend.back.Domain.user.User;
import com.backend.back.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackApplication.class)
@Transactional
public class UserServiceTest {
    @MockBean
    UserService userService;
    @MockBean
    UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception{
        //Given
        User user = new User();
        user.setMail("asd@naver.com");
        // When
        Long savedId = userService.join(user);
        // Then
        assertEquals(user,userRepository.findById(savedId));
    }

}