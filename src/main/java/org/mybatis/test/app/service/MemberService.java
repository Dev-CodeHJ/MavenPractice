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

    public Boolean join(MemberDto member) {
        if (mapper.findByMember(member.getMemberId())==null) {
            mapper.join(member);
            return true;
        } else {
            return false;
        }
    }

    public Boolean login(String memberId, String pw) {
        MemberDto member = mapper.findByMember(memberId);
        if (member != null) {
            return member.getPw().equals(pw);
        }
        return false;
    }
}
