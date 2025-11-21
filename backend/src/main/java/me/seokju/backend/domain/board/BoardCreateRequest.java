package me.seokju.backend.domain.board;

public record BoardCreateRequest(
        String title,
        String content
) {
}