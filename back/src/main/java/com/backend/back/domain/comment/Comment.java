package com.backend.back.domain.comment;

import com.backend.back.domain.board.Board;
import com.backend.back.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    private String description;
    private LocalDateTime created_time;
    private LocalDateTime modified_date;

    public Comment(String description, LocalDateTime created_time) {
        this.description = description;
        this.created_time = created_time;
    }

    public void modify(String description) {
        this.description=description;
        this.modified_date=LocalDateTime.now();
    }
}
