package me.seokju.backend.application.member;

import lombok.RequiredArgsConstructor;
import me.seokju.backend.application.member.provied.MemberRegister;
import me.seokju.backend.domain.member.*;
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
        checkDuplicateEmail(request);

        Member member = Member.register(request);

        return memberRepository.save(member);
    }

    private void checkDuplicateEmail(MemberRegisterRequest request) {
        if (memberRepository.findByEmail(new Email(request.email())).isPresent()) {
            throw new DuplicateEmailException("이미 존재하는 이메일입니다. email: " + request.email());
        }
    }
}
