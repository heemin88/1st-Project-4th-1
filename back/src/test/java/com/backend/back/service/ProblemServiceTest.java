package com.backend.back.service;

import com.backend.back.BackApplication;
import com.backend.back.Domain.problem.Problem;
import com.backend.back.Domain.user.User;
import com.backend.back.repository.ProblemRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackApplication.class)
class ProblemServiceTest {
    @MockBean
    ProblemService problemService;
    @MockBean
    ProblemRepository problemRepository;
    @MockBean
    UserService userService;

    @Test
    void 유저문제등록() {
        User user=new User("hys3396","1234","1",3);
        userService.join(user);
        Problem problem = new Problem();
        Long problem_id = problemService.register_userProblem(problem,user);

        assertEquals(problem,problemRepository.findById(problem_id));

    }

}