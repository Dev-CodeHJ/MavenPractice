package org.mybatis.test.app.controller;

import lombok.RequiredArgsConstructor;
import org.mybatis.test.app.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

}
