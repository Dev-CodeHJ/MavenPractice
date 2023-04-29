package org.mybatis.test.app.service;

import org.junit.jupiter.api.Test;
import org.mybatis.test.app.dto.MemberDto;
import org.mybatis.test.app.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberMapper mapper;
    @Autowired
    MemberService service;

    @Test
    void join() {
        //given
        MemberDto member = MemberDto.builder()
                .memberId("gnlwls0127")
                .pw("1234")
                .name("김휘진")
                .gender("남자")
                .email("gnlwls0127@naver.com")
                .build();

        MemberDto member1 = MemberDto.builder()
                .memberId("gnlwls0127")
                .pw("12345")
                .name("김휘진1")
                .gender("남자1")
                .email("gnlwls0127@naver.com1")
                .build();

        MemberDto member2 = MemberDto.builder()
                .memberId(" ")
                .pw("12345")
                .name("김휘진1")
                .gender("남자1")
                .email("gnlwls0127@naver.com1")
                .build();

        //when
        String success = service.join(member);
        String exist = service.join(member1);
        String blank = service.join(member2);

        //then
        assertThat(success).isEqualTo("ok");
        assertThat(exist).isEqualTo("exist");
        assertThat(blank).isEqualTo("member_id");
        System.out.println("member = " + member);
        System.out.println("exist = " + exist);
        System.out.println("blank = " + blank);
    }

    @Test
    void joinCheck() {
        //given
        MemberDto member = MemberDto.builder()
                .memberId("gnlwls0127")
                .pw("1234")
                .name(" ")
                .gender("남자")
                .email("gnlwls0127@naver.com")
                .build();

        //when
        String check = service.joinCheck(member);

        //then
        assertThat(check).isEqualTo("name");
        System.out.println("check = " + check);
    }

    @Test
    void login() {
        //given
        MemberDto member = MemberDto.builder()
                .memberId("gnlwls0127")
                .pw("1234")
                .name("김휘진")
                .gender("남자")
                .email("gnlwls0127@naver.com")
                .build();
        mapper.join(member);

        //when
        String loginMember = service.login("gnlwls0127", "1234");
        String invalidMemberId = service.login("gnlwls012", "1234");
        String invalidPw = service.login("gnlwls0127", "123");

        //then
        assertThat(loginMember).isEqualTo("ok");
        assertThat(invalidMemberId).isEqualTo("memberId");
        assertThat(invalidPw).isEqualTo("pw");
        System.out.println("loginMember = " + loginMember);
        System.out.println("invalidMemberId = " + invalidMemberId);
        System.out.println("invalidPw = " + invalidPw);
    }

    @Test
    void deleteMember() {
        //given
        MemberDto member = MemberDto.builder()
                .memberId("gnlwls01271")
                .pw("1234")
                .name("김휘진")
                .gender("남자")
                .email("gnlwls0127@naver.com")
                .build();
        mapper.join(member);

        //when
        String msg = service.deleteMember(member.getMemberId(), member.getPw());

        //then
        assertThat(msg).isEqualTo("ok");
        System.out.println("member = " + member);
    }
}