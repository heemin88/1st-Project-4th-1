package com.backend.back.service;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.problem.LevelProblem;
import com.backend.back.Domain.problem.Problem;
import com.backend.back.Domain.user.User;
import com.backend.back.repository.ProblemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProblemService {
    final private ProblemRepository problemRepository;

    /**
     * 유저에 문제 등록 Service
     */
    public  Long register_userProblem(Problem problem,User user) {
        problem.setUser(user);
        List<Problem> problems = user.getProblems();
        problems.add(problem);
        return problem.getId();
    }
    /**
     * 받은날짜 기준 문제 찾기 service
     */
    public List<Problem> findProblemByDate(LocalDateTime dateTime){
        return problemRepository.findProblemByDate(dateTime);
    }
    /**
     * level별 문제 기준 문제 찾기 service
     */
    public List<Problem> findProblemByLevelProblem(LevelProblem levelProblem){
        return problemRepository.findProblemByLevelProblem(levelProblem);
    }
    /**
     * 공통 Service
     */

    public Problem findProblemById(Long id) {
        return problemRepository.findProblemById(id);
    }

    public List<Problem> findProblemByUser(User user) {
        return problemRepository.findProblemByUser(user);
    }
}
