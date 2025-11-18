package me.seokju.backend.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Password(
        @Column(name = "password")
        String value
) {
}
