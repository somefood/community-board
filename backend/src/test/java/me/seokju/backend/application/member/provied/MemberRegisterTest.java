package me.seokju.backend.application.member.provied;

import me.seokju.backend.domain.member.Member;
import me.seokju.backend.domain.member.MemberRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRegisterTest {

    @Autowired
    private MemberRegister memberRegister;

    @Test
    void register() {
        MemberRegisterRequest memberRegisterRequest = new MemberRegisterRequest("seokju@seokju.com", "password");

        Member member = memberRegister.register(memberRegisterRequest);

        assertThat(member.getId()).isNotNull();
        assertThat(member.getEmail()).isNotNull();
    }
}