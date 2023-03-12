package com.backend.back.service;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.problem.LevelProblem;
import com.backend.back.Domain.problem.LevelProblemType;
import com.backend.back.Domain.problem.Problem;
import com.backend.back.Domain.user.User;
import com.backend.back.repository.LevelProblemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LevelProblemService {
    final private LevelProblemRepository levelProblemRepository;

    /**
     * 문제 등록 Service
     */
    @Transactional
    public  Long register_problems(List<Problem> problems, LevelProblemType level) {
        LevelProblem levelProblem = new LevelProblem();
        levelProblem.setProblem(problems);
        levelProblem.setLevel(level);
        levelProblemRepository.save(levelProblem);
        return levelProblem.getId();
    }
    /**
     * 문제 추가
     */
    @Transactional
    public Long add_problem(LevelProblem levelProblem,Problem problem){
        problem.setLevelProblem(levelProblem);
        List<Problem> problems = levelProblem.getProblem();
        problems.add(problem);
        levelProblemRepository.save(levelProblem);
        return levelProblem.getId();
    }
    /**
     * 공통 Service
     */

    public LevelProblem findLevelProblemById(Long id) {
        return levelProblemRepository.findLevelProblemById(id);
    }
}
