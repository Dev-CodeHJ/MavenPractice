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

        System.out.println("service.join");

        String msg = joinCheck(member);

        if (mapper.findByMember(member.getMemberId()) != null) {
            System.out.println("중복된회원");
            return "exist";
        } else if (msg.equals("ok")) {
            mapper.join(member);
            System.out.println("회원가입성공");
            return msg;
        }
        System.out.println("미입력사항있음");
        return msg;
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
            return "member_id";
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
