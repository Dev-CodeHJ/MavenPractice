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

        System.out.println("Hi");
        model.addAttribute("check", 1);



        return "join";
    }

    @PostMapping("/join")
    public ModelAndView join(ModelAndView model, HttpServletRequest request) {

        MemberDto dto =new MemberDto();

        dto.setPw(request.getParameter("pw"));
        dto.setName(request.getParameter("name"));
        dto.setMemberId(request.getParameter("member_id"));
        dto.setGender(request.getParameter("inlineRadioOptions"));
        dto.setEmail(request.getParameter("email"));
        System.out.println("12");
        System.out.println("1:"+dto.getMemberId());
        System.out.println("2:"+dto.getPw());
        System.out.println("3:"+dto.getName());
        System.out.println("4:"+dto.getGender());
        System.out.println("5:"+dto.getEmail());
        //model.addAttribute("check", 2);
        model.addObject("check", 2);
        if (memberService.join(dto)) {
            //model.addAttribute("msg", "회원가입이 완료되었습니다.");
            model.addObject("msg", "회원가입이 완료되었습니다.");
        } else{
            //model.addAttribute("msg","중복된 아이디가 존재합니다");
            model.addObject("msg", "중복된 아이디가 존재합니다.");
        }
        return model;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
