package org.mybatis.test.app.controller;

import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.dto.MemberDto;
import org.mybatis.test.app.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @GetMapping("/login")
    public String login(@ModelAttribute("member") MemberDto member, Model model) {
        return "login";
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("member") MemberDto member, Model model) {
        return "join";
    }
}
