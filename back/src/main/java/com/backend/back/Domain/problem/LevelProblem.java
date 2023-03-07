package com.backend.back.Domain.problem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="LevelProblem")
@Getter
@Setter
@NoArgsConstructor //빈 생성자를 만드는 어노테이션
public class LevelProblem {
    @Id
    @GeneratedValue
    @Column(name ="levelProblem_id")
    private Long id;
    private String level;

    @OneToMany(mappedBy = "levelProblem")
    private List<Problem> problem = new ArrayList<>();
}
