package org.mybatis.test.app.controller;

import lombok.AllArgsConstructor;
import org.mybatis.test.app.dto.MemberDto;
import org.mybatis.test.app.service.BoardService;
import org.mybatis.test.app.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {
    @Resource
    BoardService boardService;
    @Resource
    MemberService memberService;

    @GetMapping()
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/join")
    public String join(Model model) {

        System.out.println("joinPage");
        model.addAttribute("check", 1);

        return "join";
    }

    @PostMapping("/join")
    public ModelAndView join(ModelAndView model, HttpServletRequest request) {

        MemberDto member =new MemberDto();

        member.setMemberId(request.getParameter("member_id"));
        member.setPw(request.getParameter("pw"));
        member.setName(request.getParameter("name"));
        member.setGender(request.getParameter("gender"));
        member.setEmail(request.getParameter("email"));
        System.out.println("doJoin");
        System.out.println("1:"+member.getMemberId());
        System.out.println("2:"+member.getPw());
        System.out.println("3:"+member.getName());
        System.out.println("4:"+member.getGender());
        System.out.println("5:"+member.getEmail());
        model.addObject("check", 2);
        if (memberService.join(member).equals("ok")) {
            model.addObject("msg", "회원가입이 완료되었습니다.");
        } else{
            model.addObject("msg", "중복된 아이디가 존재합니다.");
        }
        return model;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
