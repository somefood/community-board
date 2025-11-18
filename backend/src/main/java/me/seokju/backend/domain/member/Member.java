package me.seokju.backend.domain.member;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    public static Member register(MemberRegisterRequest registerRequest) {
        Member member = new Member();

        member.email = new Email(registerRequest.email());
        member.password = new Password(registerRequest.password());

        return member;
    }
}
