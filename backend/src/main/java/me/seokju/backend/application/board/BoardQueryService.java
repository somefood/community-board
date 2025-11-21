package me.seokju.backend.application.board;

import lombok.RequiredArgsConstructor;
import me.seokju.backend.application.board.provied.BoardFinder;
import me.seokju.backend.domain.board.Board;
import me.seokju.backend.domain.board.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardQueryService implements BoardFinder {

    private final BoardRepository boardRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Board findById(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" + boardId));
    }
}
