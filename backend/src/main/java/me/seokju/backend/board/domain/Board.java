package me.seokju.backend.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private BoardStatus status;

    private Board(String title, String content, BoardStatus status) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.status = status;
    }

    public static Board create(String title, String content) {
        return new Board(title, content, BoardStatus.ACTIVE);
    }

    public void delete() {
        this.status = BoardStatus.DELETED;
        this.updatedAt = LocalDateTime.now();
    }
}
