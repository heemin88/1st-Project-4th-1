package com.backend.back.repository;

import com.backend.back.domain.User;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=UserRepository.class)
public class UserRepositoryTest {
    @Autowired UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testUser(){
        User user = new User();
        user.setMail("1234@naver.com");
        Long savedId = userRepository.save(user);
        User findUser = userRepository.find(savedId);
        Assertions.assertThat(findUser.getUid()).isEqualTo(user.getUid());
        Assertions.assertThat(findUser.getMail()).isEqualTo(user.getMail());
        Assertions.assertThat(findUser).isEqualTo(user);
    }

}