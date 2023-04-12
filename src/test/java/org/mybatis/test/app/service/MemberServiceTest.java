package org.mybatis.test.app.service;

import org.junit.jupiter.api.Test;
import org.mybatis.test.app.dto.MemberDto;
import org.mybatis.test.app.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
        assertThat(blank).isEqualTo("memberId");
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
        Boolean loginValidation = service.login(member.getMemberId(), member.getPw());

        //then
        assertThat(loginValidation).isTrue();
        System.out.println("loginValidation = " + loginValidation);
    }
}