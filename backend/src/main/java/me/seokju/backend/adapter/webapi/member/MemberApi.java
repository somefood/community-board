package me.seokju.backend.adapter.webapi.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.seokju.backend.adapter.webapi.member.dto.MemberRegisterResponse;
import me.seokju.backend.application.member.provied.MemberRegister;
import me.seokju.backend.domain.member.Member;
import me.seokju.backend.domain.member.MemberRegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberApi {
    private final MemberRegister memberRegister;

    @PostMapping("/api/members")
    public MemberRegisterResponse register(@RequestBody @Valid MemberRegisterRequest request) {
        Member member = memberRegister.register(request);

        return MemberRegisterResponse.of(member);
    }
}
