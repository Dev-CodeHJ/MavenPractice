package org.mybatis.test.app.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.service.BoardService;
import org.mybatis.test.app.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@AllArgsConstructor
public class HomeController {
    private BoardService boardService;
    private MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/main")
    public String main() {
        return "main";
    }

}
