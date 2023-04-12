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

    public String join(MemberDto member) {

        if (mapper.findByMember(member.getMemberId()) != null) {
            return "exist";
        } else if (joinCheck(member).equals("ok")) {
            mapper.join(member);
            return joinCheck(member);
        }
        return joinCheck(member);
    }

    public Boolean login(String memberId, String pw) {
        MemberDto member = mapper.findByMember(memberId);
        if (member != null) {
            return member.getPw().equals(pw);
        }
        return false;
    }

    public String joinCheck(final MemberDto member) {

        if (member.getMemberId() == null || member.getMemberId().isBlank()) {
            log.warn("The input memberId cannot be null or empty.");
            return "memberId";
        }

        else if (member.getPw() == null || member.getPw().isBlank()) {
            log.warn("The input pw cannot be null or empty.");
            return "pw";
        }

        else if (member.getName() == null || member.getName().isBlank()) {
            log.warn("The input name cannot be null or empty.");
            return "name";
        }

        else if (member.getGender() == null || member.getGender().isBlank()) {
            log.warn("The input gender cannot be null or empty.");
            return "gender";
        }

        else if (member.getEmail() == null || member.getEmail().isBlank()) {
            log.warn("The input email cannot be null or empty.");
            return "email";
        }
        return "ok";
    }
}
