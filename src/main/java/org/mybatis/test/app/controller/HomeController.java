package org.mybatis.test.app.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.dto.MemberDto;
import org.mybatis.test.app.service.BoardService;
import org.mybatis.test.app.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@AllArgsConstructor
public class HomeController {
    private BoardService boardService;
    private MemberService memberService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("check", 1);
        return "join";
    }

    @PostMapping("/join")
    public String join(Model model, MemberDto member) {
        model.addAttribute("check", 2);
        if (memberService.join(member)) {
            model.addAttribute("msg", "회원가입이 완료되었습니다.");
        } else
        {model.addAttribute("msg","중복된 아이디가 존재합니다");}
        return "join";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
