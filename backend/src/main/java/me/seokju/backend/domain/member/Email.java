package me.seokju.backend.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Email(
        @Column(name = "email")
        String value
) {
}
