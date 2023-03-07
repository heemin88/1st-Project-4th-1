package com.backend.back.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor //빈 생성자를 만드는 어노테이션
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private long uid;
    private String mail;
    private String password;
    private String level;
    private int problem_count;

    @OneToMany(mappedBy = "user")
    private List<Problem> problems = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Board> posts = new ArrayList<>();

    @OneToMany(mappedBy = "comment")
    private List<Comment> comments = new ArrayList<>();





}
