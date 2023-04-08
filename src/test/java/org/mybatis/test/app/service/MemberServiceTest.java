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

        //when
        Boolean joinValidation = service.join(member);

        //then
        assertThat(joinValidation).isTrue();
        System.out.println("joinValidation = " + joinValidation);
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