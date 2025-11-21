package me.seokju.backend.application.board.provied;

import me.seokju.backend.domain.board.Board;
import me.seokju.backend.domain.board.BoardCreateRequest;

public interface BoardRegister {

    Board create(BoardCreateRequest boardCreateRequest );

    Board remove(Long boardId);
}
