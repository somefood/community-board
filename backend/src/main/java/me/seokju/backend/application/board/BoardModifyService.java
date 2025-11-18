package me.seokju.backend.application.board;

import lombok.RequiredArgsConstructor;
import me.seokju.backend.application.board.provied.BoardRegister;
import me.seokju.backend.domain.board.Board;
import me.seokju.backend.domain.board.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardModifyService implements BoardRegister {

    private final BoardRepository boardRepository;

    @Override
    public Board create(String title, String content) {
        Board board = Board.create(title, content);
        return boardRepository.save(board);
    }

    @Override
    public Board remove(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" + boardId));
        board.delete();
        return board;
    }
}
