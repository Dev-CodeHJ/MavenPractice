package org.mybatis.test.app.mapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.test.app.dto.BoardDto;
import org.mybatis.test.app.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberMapperTest {

    @Autowired
    private MemberMapper mapper;

    @Test
    void join() {
        //given
        MemberDto member = MemberDto.builder()
                .memberId("gnlwls0127")
                .pw("1234")
                .name("김휘진")
                .gender("남자")
                .email("hj@naver.com")
                .build();

        //when
        mapper.join(member);

        //then
        assertThat(mapper.findByMember(member.getMemberId())).isEqualTo(member);
        System.out.println("member = " + member);
    }

    @Test
    void findByMember() {
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
        MemberDto foundMember = mapper.findByMember(member.getMemberId());

        //then
        assertThat(foundMember.getName()).isEqualTo("김휘진");
        System.out.println("MemberName = " + foundMember.getName());
    }

    @Test
    void login() {
        //given
        MemberDto member = MemberDto.builder()
                .memberId("gnlwls0127")
                .pw("1234")
                .name("김휘진")
                .gender("남자")
                .email("hj@naver.com")
                .build();
        mapper.join(member);

        //when
        MemberDto loginMember = mapper.login(member.getMemberId(), member.getPw());

        //then
        assertThat(loginMember.getPw()).isEqualTo("1234");
        System.out.println("loginMember = " + loginMember);
    }

    @Test
    void updateMember() {
        //given
        MemberDto member = MemberDto.builder()
                .memberId("gnlwls0127")
                .pw("1234")
                .name("김휘진")
                .gender("남자")
                .email("hj@naver.com")
                .build();
        mapper.join(member);

        MemberDto member1 = MemberDto.builder()
                .memberId("gnlwls0127")
                .pw("123")
                .name("춘향")
                .gender("여자")
                .email("ch@naver.com")
                .build();

        //when
        mapper.updateMember(member1);
        MemberDto existMember = mapper.findByMember(member.getMemberId());

        //then
        assertThat(member1).isEqualTo(existMember);
        System.out.println("member1 = " + member1);
        System.out.println("existMember = " + existMember);
    }

    @Test
    void deleteMember() {
        //given
        MemberDto member = MemberDto.builder()
                .memberId("gnlwls0127")
                .pw("1234")
                .name("김휘진")
                .gender("남자")
                .email("hj@naver.com")
                .build();
        mapper.join(member);

        MemberDto member1 = MemberDto.builder()
                .memberId("cnsgid")
                .pw("123")
                .name("춘향")
                .gender("춘향")
                .email("ch@naver.com")
                .build();
        mapper.join(member1);

        //when
        mapper.deleteMember(member);

        //then
        assertThat(mapper.findByMember(member.getMemberId())).isNull();
        System.out.println("mapper = " + mapper.findByMember(member.getMemberId()));
    }
}