package me.seokju.backend.adapter.webapi.board;

import lombok.RequiredArgsConstructor;
import me.seokju.backend.adapter.webapi.board.dto.BoardResponse;
import me.seokju.backend.application.board.provied.BoardFinder;
import me.seokju.backend.application.board.provied.BoardRegister;
import me.seokju.backend.domain.board.Board;
import me.seokju.backend.domain.board.BoardCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardFinder boardFinder;
    private final BoardRegister boardRegister;

    @GetMapping
    public ResponseEntity<List<BoardResponse>> getAllBoards() {
        List<Board> boards = boardFinder.findAll();
        List<BoardResponse> responses = boards.stream()
                .map(BoardResponse::from)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getBoard(@PathVariable Long id) {
        Board board = boardFinder.findById(id);
        return ResponseEntity.ok(BoardResponse.from(board));
    }

    @PostMapping
    public ResponseEntity<BoardResponse> createBoard(@RequestBody BoardCreateRequest request) {
        Board board = boardRegister.create(request);
        return ResponseEntity.ok(BoardResponse.from(board));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardRegister.remove(id);
        return ResponseEntity.noContent().build();
    }
}