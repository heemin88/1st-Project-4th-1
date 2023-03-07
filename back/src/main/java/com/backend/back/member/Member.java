package com.backend.back.member;

import com.backend.back.Domain.board.Board;
import com.backend.back.Domain.comment.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Board> BoardList=new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Comment> commentList=new ArrayList<>();

    private String userId;
    private String password;
    private String level;
    private Integer problem_count;
}
