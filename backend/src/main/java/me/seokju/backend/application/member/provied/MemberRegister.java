package me.seokju.backend.application.member.provied;

import jakarta.validation.Valid;
import me.seokju.backend.domain.member.Member;
import me.seokju.backend.domain.member.MemberRegisterRequest;

public interface MemberRegister {

    Member register(@Valid MemberRegisterRequest request);
}
