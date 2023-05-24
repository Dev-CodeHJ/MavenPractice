package org.mybatis.test.app.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.dto.BoardDto;
import org.mybatis.test.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService service;

    @GetMapping("/boardList")
    public String boardList(Model model) {
        service.readAll();
        return "boardList";
    }
}
