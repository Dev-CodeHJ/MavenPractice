package org.mybatis.test.app.controller;

import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.dao.BoardMapper;
import org.mybatis.test.app.dto.BoardDto;
import org.mybatis.test.app.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardMapper mapper;
    private final BoardService boardService;

    @GetMapping("/mybatis")
    public String mybatisTest(Model model) {
        List<BoardDto> dtoList = boardService.findAll();
        model.addAttribute("list", dtoList);
        return "/board/hello";
    }

    @RequestMapping("/")
    public String list(Model model) {
        model.addAttribute("list", mapper.findAll());
        return "index";
    }

    @RequestMapping(value = "request 주소", method = RequestMethod.POST)
    public String write(BoardDto dto) {
        return "redirect:";
    }
}
