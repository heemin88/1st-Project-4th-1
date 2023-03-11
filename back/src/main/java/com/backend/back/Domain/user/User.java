package com.backend.back.Domain.user;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.comment.Comment;
import com.backend.back.Domain.problem.Problem;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long uid;
    private String mail;
    private String password;
    private String level;
    private int problem_count;

    @OneToMany(mappedBy = "user")
    private List<Problem> problems = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Board> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    public User(String mail, String password, String level, int problem_count) {
        this.mail = mail;
        this.password = password;
        this.level = level;
        this.problem_count = problem_count;
    }
}
