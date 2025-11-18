package me.seokju.backend.application.board.provied;

import me.seokju.backend.domain.board.Board;

public interface BoardRegister {

    Board create(String title, String content);

    Board remove(Long boardId);
}
