package com.example.spring_test02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @GetMapping("/detail")
    public String detail() {
        return "view.html";
    }
}
