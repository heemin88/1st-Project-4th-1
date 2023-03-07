package com.backend.back.Domain.board;

import com.backend.back.Domain.comment.Comment;
import com.backend.back.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="BOARD")
public class Board {

    @Id
    @GeneratedValue
    @Column(name="BOARD_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL)
    private List<Comment> commentList=new ArrayList<>();

    private String title;
    private String description;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
    private Integer view_count;


    @Enumerated(EnumType.STRING)
    private com.backend.back.Domain.board.BoardType status; // Question,

}
