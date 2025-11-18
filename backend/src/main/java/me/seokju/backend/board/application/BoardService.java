package me.seokju.backend.board.application;

import lombok.RequiredArgsConstructor;
import me.seokju.backend.board.domain.Board;
import me.seokju.backend.board.domain.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    
    public Board createBoard(String title, String content) {
        Board board = Board.create(title, content);
        return boardRepository.save(board);
    }
    
    public Board deleteBoard(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" + boardId));
        board.delete();
        return board;
    }
}
