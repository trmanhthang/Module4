package com.example.demo_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
    @GetMapping("/greeting")
    public ModelAndView showGreeting(){
        return new ModelAndView("/greeting");
    }
}
