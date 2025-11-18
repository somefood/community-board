package me.seokju.backend.member.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public record Password(String value) {
}
