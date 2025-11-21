package me.seokju.backend.application.board.provied;

import me.seokju.backend.domain.board.Board;

import java.util.List;

public interface BoardFinder {
    List<Board> findAll();

    Board findById(Long boardId);
}
