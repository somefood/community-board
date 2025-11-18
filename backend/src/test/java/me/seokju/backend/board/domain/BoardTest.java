package me.seokju.backend.board.domain;

import me.seokju.backend.domain.board.Board;
import me.seokju.backend.domain.board.BoardStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    @Test
    @DisplayName("게시글을 생성한다")
    void create() {
        var board = Board.create("title", "content");

        assertThat(board.getTitle()).isEqualTo("title");
        assertThat(board.getContent()).isEqualTo("content");
        assertThat(board.getStatus()).isEqualTo(BoardStatus.ACTIVE);
        assertThat(board.getCreatedAt()).isNotNull();
    }

    @Test
    @DisplayName("게시글을 삭제한다")
    void delete() {
        var board = Board.create("title", "content");

        board.delete();

        assertThat(board.getStatus()).isEqualTo(BoardStatus.DELETED);
        assertThat(board.getUpdatedAt()).isNotNull();
    }
}