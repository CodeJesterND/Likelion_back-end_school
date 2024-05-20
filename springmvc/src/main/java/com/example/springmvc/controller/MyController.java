package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {
    @GetMapping("/home")
    public String name() {
        return "home";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @GetMapping("/con")
    public String contact() {
        return "contract";
    }

    @ResponseBody
    @GetMapping("rest")
    public String rest() {
        return "restbody test!!!";
    }
}