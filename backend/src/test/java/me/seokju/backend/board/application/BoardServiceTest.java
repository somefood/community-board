package me.seokju.backend.board.application;

import jakarta.persistence.EntityManager;
import me.seokju.backend.application.board.BoardService;
import me.seokju.backend.domain.board.Board;
import me.seokju.backend.domain.board.BoardStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private EntityManager em;

    @Test 
    void createBoard() {
        Board board = boardService.createBoard("title", "content");
        
        assertThat(board).isNotNull();
        assertThat(board.getTitle()).isEqualTo("title");
        assertThat(board.getContent()).isEqualTo("content");
        assertThat(board.getStatus()).isEqualTo(BoardStatus.ACTIVE);
        assertThat(board.getCreatedAt()).isNotNull();
    }
    
    @Test 
    void deleteBoard() {
        Board board = boardService.createBoard("title", "content");
        em.flush();
        em.clear();
        
        Long boardId = board.getId();
        Board deletedBoard = boardService.deleteBoard(boardId);

        assertThat(deletedBoard.getStatus()).isEqualTo(BoardStatus.DELETED);
        assertThat(deletedBoard.getUpdatedAt()).isNotNull();
    }
}
