package org.mybatis.test.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/index")
    public String test() {
        return "Hello";
    }
}
