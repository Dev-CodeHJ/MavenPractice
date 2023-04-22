package org.mybatis.test.app.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.dto.MemberDto;
import org.mybatis.test.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService service;

    @GetMapping("/updateMember")
    public String updateMember(Model model) {
        model.addAttribute("check", 1);
        return "updateMember";
    }

    @PostMapping("/updateMember")
    public String updateMember(Model model, HttpServletRequest request) {

        MemberDto member = new MemberDto();

        member.setMemberId(request.getParameter("member_id"));
        member.setPw(request.getParameter("pw"));
        member.setName(request.getParameter("name"));
        member.setGender(request.getParameter("gender"));
        member.setEmail(request.getParameter("email"));

        service.updateMember(member);

        model.addAttribute("check", 2);

        return "updateMember";
    }
}
