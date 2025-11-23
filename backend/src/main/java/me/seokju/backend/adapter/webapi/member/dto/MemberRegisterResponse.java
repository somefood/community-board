package me.seokju.backend.adapter.webapi.member.dto;

import me.seokju.backend.domain.member.Member;

public record MemberRegisterResponse(
        Long memberId,
        String email
) {

    public static MemberRegisterResponse of(Member member) {
        return new MemberRegisterResponse(
                member.getId(),
                member.getEmail().address()
        );
    }
}
