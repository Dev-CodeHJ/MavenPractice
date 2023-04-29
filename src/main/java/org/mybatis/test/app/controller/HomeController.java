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
import javax.servlet.http.HttpSession;
import java.util.Optional;

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

        System.out.println("controller.join");

        member.setMemberId(request.getParameter("member_id"));
        member.setPw(request.getParameter("pw"));
        member.setName(request.getParameter("name"));
        member.setGender(request.getParameter("gender"));
        member.setEmail(request.getParameter("email"));

        String msg = memberService.join(member);
        model.addObject("check", 2);

        if (msg.equals("exist")) {
            System.out.println("controller.exist");
            model.addObject("msg", msg);
        } else if (msg.equals("ok")){
            System.out.println("controller.ok");
            model.addObject("msg", msg);
        } else {
            System.out.println("controller.blank");
            System.out.println("msg = " + msg);
            model.addObject("msg", msg);
        }
        System.out.println("model = " + model);
        return model;
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("check", 1);

        return "login";
    }

    @PostMapping("login")
    public ModelAndView login(ModelAndView model, HttpServletRequest request) {

        System.out.println("controller.login");

        String memberId = request.getParameter("member_id");
        String pw = request.getParameter("pw");

        String msg = memberService.login(memberId, pw);
        model.addObject("check", 2);
        model.addObject("msg", msg);

        if (msg.equals("ok")) {
            MemberDto loginMember = memberService.loginSuccess(memberId, pw);
            HttpSession session = request.getSession();
            session.setAttribute("loginMember", loginMember);
            session.setAttribute("member_id", loginMember.getMemberId());
            session.setAttribute("pw", loginMember.getPw());
            session.setAttribute("name", loginMember.getName());
            session.setAttribute("gender", loginMember.getGender());
            session.setAttribute("email", loginMember.getEmail());
        }
        return model;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "logout";
    }
}