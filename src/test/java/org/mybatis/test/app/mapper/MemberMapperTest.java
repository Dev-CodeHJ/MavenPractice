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
    void findByMember() {
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
        MemberDto foundMember = mapper.findByMember(member);

        //then
        assertThat(foundMember).isEqualTo(member);
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
        assertThat(loginMember.getPw()).isNull();
        System.out.println("loginMember = " + loginMember);
    }

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
        MemberDto foundMember = mapper.findByMember(member);

        //then
        assertThat(foundMember).isEqualTo(member);
        System.out.println("MemberId() = " + foundMember.getMemberId());
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

        //when
        mapper.updateMember(member);

        //then

    }

    @Test
    void deleteMember() {
        //given

        //when

        //then

    }
}