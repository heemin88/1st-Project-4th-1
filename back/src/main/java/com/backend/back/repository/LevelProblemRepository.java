package com.backend.back.repository;

import com.backend.back.Domain.problem.LevelProblem;
import com.backend.back.Domain.problem.LevelProblemType;
import com.backend.back.Domain.problem.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelProblemRepository extends JpaRepository<LevelProblem,Long> {

    LevelProblem findLevelProblemById(Long id);
    List<Problem> findLevelProblemByLevel(LevelProblemType level);
}
