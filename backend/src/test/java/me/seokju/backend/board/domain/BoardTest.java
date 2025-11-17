package me.seokju.backend.board.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    @Test
    void create() {
        var board = Board.create("title", "content");

        assertThat(board.getTitle()).isEqualTo("title");
        assertThat(board.getContent()).isEqualTo("content");
        assertThat(board.getStatus()).isEqualTo(BoardStatus.ACTIVE);
    }

    @Test
    void delete() {
        var board = Board.create("title", "content");

        board.delete();

        assertThat(board.getStatus()).isEqualTo(BoardStatus.DELETED);
    }
}