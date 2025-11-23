package me.seokju.backend.domain.member;

public class MemberFixture {

    public static MemberRegisterRequest createMemberRegisterRequest(String email) {
        return new MemberRegisterRequest(
                email,
                "verysecret"
        );
    }

    public static MemberRegisterRequest createMemberRegisterRequest() {
        return createMemberRegisterRequest("somefood@test.app");
    }
}
