package org.mybatis.test.app.controller;

import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.dto.BoardDto;
import org.mybatis.test.app.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @PostMapping("/create")
    public String createBoard(BoardDto dto) {
        service.create(dto);
        return null;
    }
}
