package org.mybatis.test.app.service;

import org.junit.jupiter.api.Test;
import org.mybatis.test.app.dto.MemberDto;
import org.mybatis.test.app.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        String joinMessage = service.join(member);

        //then
        assertThat(mapper.findByMember("gnlwls0127")).isEqualTo(member);
        System.out.println("joinMessage = " + joinMessage);
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
        MemberDto loginMember = service.login(member.getMemberId(), member.getPw());

        //then
        assertThat(loginMember).isEqualTo(member);
        System.out.println("loginMember.getPw() = " + loginMember.getPw());
    }
}