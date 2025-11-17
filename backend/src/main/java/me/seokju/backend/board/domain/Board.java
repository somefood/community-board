package me.seokju.backend.board.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Board {

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
    }
}
