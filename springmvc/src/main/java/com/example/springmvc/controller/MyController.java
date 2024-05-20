package com.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @GetMapping("con")
    public String contact() {
        return "contact";
    }

    @ResponseBody
    @GetMapping("rest")
    public String rest() {
        return "restbody test!!!";
    }

    /*
    @GetMapping("greeting")
    public String greet(String name, int age, HttpServletRequest request) {
        //http://localhost:8888/greeting?name=hyoseung
        //?name=hyoseung&age=27 쿼리문자열
        System.out.println(name);
        System.out.println(age);

        System.out.println("request:::" + request.getParameter("name"));
        System.out.println("request:::" + request.getParameter("age"));

        return "greeting";
    }
    */

    /*
    @GetMapping("greeting")
    public String greet(
            @RequestParam String name,
            @RequestParam(name="age", required = true) int age, Model model) {

        //http://localhost:8888/greeting?name=hyoseung
        //?name=hyoseung&age=27 쿼리문자열
        System.out.println(name);
        System.out.println(age);

        model.addAttribute("name", name);

        // 이때 얻은 값을.. 서비스

        return "greeting";
    }
     */

    @GetMapping("greeting")
    public ModelAndView greet(@RequestParam String name, ModelAndView modelAndView) {

        //http://localhost:8888/greeting?name=hyoseung
        //?name=hyoseung&age=27 쿼리문자열
        System.out.println(name);

        modelAndView.addObject("name", name);
        modelAndView.setViewName("greeting");

        // 이때 얻은 값을.. 서비스

        return modelAndView;
    }
}