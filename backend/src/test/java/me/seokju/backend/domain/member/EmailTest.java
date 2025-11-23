package me.seokju.backend.domain.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmailTest {

    @Test
    void equality() {
        var email1 = new Email("somefood@test.app");
        var email2 = new Email("somefood@test.app");

        assertThat(email1).isEqualTo(email2);
    }
}