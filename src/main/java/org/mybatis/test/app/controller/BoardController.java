package org.mybatis.test.app.controller;

import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.domain.Board;
import org.mybatis.test.app.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/mybatis")
    public String mybatisTest(Model model) {
        List<Board> boardList = boardService.findAll();
        model.addAttribute("list",boardList);
        return "/board/hello";
    }


}
