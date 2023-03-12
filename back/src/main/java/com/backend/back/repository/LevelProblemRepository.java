package com.backend.back.repository;

import com.backend.back.Domain.problem.LevelProblem;
import com.backend.back.Domain.problem.Problem;
import com.backend.back.Domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LevelProblemRepository extends JpaRepository<LevelProblem,Long> {

    LevelProblem findLevelProblemById(Long id);
}
