package org.mybatis.test.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.test.app.dto.MemberDto;
import org.mybatis.test.app.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mapper;

    public String join(MemberDto member) {

        System.out.println("service.join");

        String msg = joinCheck(member);

        if (msg.equals("ok")) {
            mapper.join(member);
        }
        return msg;
    }

    public Optional<MemberDto> login(String memberId, String pw) {

        System.out.println("service.login");
        Optional<MemberDto> idPassMember = Optional.ofNullable(mapper.findByMember(memberId));
        System.out.println("idPassMember = " + idPassMember);

        if (idPassMember.isEmpty()) {
            System.out.println("memberId.Empty");
        } else if (idPassMember.get().getPw().equals(pw)) {
            System.out.println("pw.OK");
        }
        return idPassMember;
    }

    public String joinCheck(final MemberDto member) {

        if (mapper.findByMember(member.getMemberId()) != null) {
            log.warn("The input memberId already exists.");
            return "exist";
        } else if (member.getMemberId() == null || member.getMemberId().isBlank()) {
            log.warn("The input memberId cannot be null or empty.");
            return "member_id";
        } else if (member.getPw() == null || member.getPw().isBlank()) {
            log.warn("The input pw cannot be null or empty.");
            return "pw";
        } else if (member.getName() == null || member.getName().isBlank()) {
            log.warn("The input name cannot be null or empty.");
            return "name";
        } else if (member.getGender() == null || member.getGender().isBlank()) {
            log.warn("The input gender cannot be null or empty.");
            return "gender";
        } else if (member.getEmail() == null || member.getEmail().isBlank()) {
            log.warn("The input email cannot be null or empty.");
            return "email";
        }
        return "ok";
    }
}
