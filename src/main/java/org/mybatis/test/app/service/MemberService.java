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

        Optional<MemberDto> loginMember = Optional.ofNullable(mapper.login(memberId, pw));

        if (loginMember.isEmpty()) {
            if (Optional.ofNullable(mapper.findByMember(memberId)).isEmpty()) {
                System.out.println("invalid memberId");
            }else {
                System.out.println("invalid password");
            }
        }
        return loginMember;
    }

    public void updateMember(MemberDto member) {
        MemberDto checkMember = updateCheck(member);
        mapper.updateMember(checkMember);
    }

    public MemberDto updateCheck(MemberDto member) {

        MemberDto existedMember = mapper.findByMember(member.getMemberId());

        if (member.getPw()==null || member.getPw().isBlank()) {
            member.setPw(existedMember.getPw());
        }
        if (member.getName()==null || member.getName().isBlank()) {
            member.setName(existedMember.getName());
        }
        if (member.getGender()==null || member.getGender().isBlank()) {
            member.setGender(existedMember.getGender());
        }
        if (member.getEmail()==null || member.getEmail().isBlank()) {
            member.setEmail(existedMember.getEmail());
        }
        return member;
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

    public String deleteMember(String memberId, String pw) {

        System.out.println("service");
        System.out.println("pw = " + pw);
        MemberDto member = mapper.findByMember(memberId);
        if (member.getPw().equals(pw)) {
            mapper.deleteMember(memberId, pw);
            System.out.println("ok");
            return "ok";
        } else {
            System.out.println("fail");
            return "fail";
        }
    }
}
