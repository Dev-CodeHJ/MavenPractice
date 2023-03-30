package org.mybatis.test.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.test.app.dto.MemberDto;
import org.mybatis.test.app.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mapper;

    public String join(final MemberDto member) {

        mapper.join(member);
        return member.getName() + "님 회원가입을 축하드립니다.";
    }

    public MemberDto login(String memberId, String pw) {

        MemberDto loginMember = mapper.login(memberId, pw);
        return loginMember;
    }
}
