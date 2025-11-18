package me.seokju.backend.application.member;

import lombok.RequiredArgsConstructor;
import me.seokju.backend.application.member.provied.MemberRegister;
import me.seokju.backend.domain.member.Member;
import me.seokju.backend.domain.member.MemberRegisterRequest;
import me.seokju.backend.domain.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@RequiredArgsConstructor
@Transactional
@Service
public class MemberModifyService implements MemberRegister {

    private final MemberRepository memberRepository;

    @Override
    public Member register(MemberRegisterRequest request) {
        Member member = Member.register(request);

        return memberRepository.save(member);
    }
}
