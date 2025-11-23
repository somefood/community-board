package me.seokju.backend.domain.member;

// @ResponseStatus(HttpStatus.CONFLICT) // 도메인 계층이 외부의 특정 기술을 의존하게 되는 것임, 지양하기
public class DuplicateEmailException extends RuntimeException{
    public DuplicateEmailException(String message) {
        super(message);
    }
}
