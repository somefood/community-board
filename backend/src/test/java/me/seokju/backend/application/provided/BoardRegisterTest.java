package me.seokju.backend.application.provided;

import jakarta.persistence.EntityManager;
import me.seokju.backend.application.board.provied.BoardRegister;
import me.seokju.backend.domain.board.Board;
import me.seokju.backend.domain.board.BoardCreateRequest;
import me.seokju.backend.domain.board.BoardStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class BoardRegisterTest {

    @Autowired
    private BoardRegister boardRegister;

    @Autowired
    private EntityManager em;

    @Test 
    void createBoard() {
        BoardCreateRequest boardCreateRequest = new BoardCreateRequest("title", "content");

        Board board = boardRegister.create(boardCreateRequest);
        
        assertThat(board).isNotNull();
        assertThat(board.getTitle()).isEqualTo("title");
        assertThat(board.getContent()).isEqualTo("content");
        assertThat(board.getStatus()).isEqualTo(BoardStatus.ACTIVE);
        assertThat(board.getCreatedAt()).isNotNull();
    }
    
    @Test 
    void deleteBoard() {
        BoardCreateRequest boardCreateRequest = new BoardCreateRequest("title", "content");
        Board board = boardRegister.create(boardCreateRequest);
        em.flush();
        em.clear();
        
        Long boardId = board.getId();
        Board deletedBoard = boardRegister.remove(boardId);

        assertThat(deletedBoard.getStatus()).isEqualTo(BoardStatus.DELETED);
        assertThat(deletedBoard.getUpdatedAt()).isNotNull();
    }
}
