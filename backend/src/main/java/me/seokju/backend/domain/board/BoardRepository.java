package me.seokju.backend.domain.board;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends Repository<Board, Long> {

    Board save(Board board);

    Optional<Board> findById(Long id);

    List<Board> findAll();
}
