package me.seokju.backend.board.domain;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface BoardRepository extends Repository<Board, Long> {
    
    Board save(Board board);
    
    Optional<Board> findById(Long id);
}
