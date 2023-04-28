package org.mybatis.test.app.controller;

import lombok.AllArgsConstructor;
import org.mybatis.test.app.dto.MemberDto;
import org.mybatis.test.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService service;

    @GetMapping("/updateMember")
    public String updateMember(Model model, String pw) {


        model.addAttribute("check", 1);
        return "updateMember";
    }

    @PostMapping("/updateMember")
    public String updateMember(Model model, HttpServletRequest request) {

        MemberDto member = new MemberDto();

        model.addAttribute("check", 2);

        System.out.println(request.getParameter("pw"));
        System.out.println(request.getParameter("pw1"));
        if (request.getParameter("pw").equals(request.getParameter("pw1"))) {
            member.setMemberId(request.getParameter("member_id"));
            member.setPw(request.getParameter("pw"));
            member.setName(request.getParameter("name"));
            member.setGender(request.getParameter("gender"));
            member.setEmail(request.getParameter("email"));

            service.updateMember(member);
        } else {
            model.addAttribute("msg", "error");
        }
        return "updateMember";
    }

    @GetMapping("/deleteMember")
    public String deleteMember(Model model, HttpServletRequest request) {

        System.out.println("delete");
        HttpSession session = request.getSession();

        String memberId = (String) session.getAttribute("member_id");
        String pw = (String) session.getAttribute("pw");
        System.out.println("memberId = " + memberId);
        System.out.println("pw = " + pw);

        String msg = service.deleteMember(memberId, pw);
        System.out.println("msg = " + msg);
        model.addAttribute("msg", msg);
        return "deleteMember";
    }
}
