package com.example.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class RoutingController {
    @GetMapping("/start")
    public String startProcess(Model model) {
        // 이 메소드는 요청을 /forward로 포워드합니다.
        model.addAttribute("forwardTest", "hyoseung");
        return "forward:/forward";
    }

    @GetMapping("/forward")
    public String forward() {
        // 이 메소드는 실제로 처리를 수행하고, 뷰 이름을 반환합니다.
        return "forwardPage"; // forwardPage.html 또는 forwardPage.jsp 등의 뷰 파일을 참조
    }

    @GetMapping("/redirect")
    public String redirect() {
        // 이 메소드는 요청을 /finalDestination으로 리다이렉트합니다.
        return "redirect:/finalDestination";
    }

    @GetMapping("/finalDestination")
    public String finalDestination() { // 최종 목적지 페이지를 반환합니다.
        return "finalPage"; // finalPage.html 또는 finalPage.jsp 등의 뷰 파일을 참조
    }
}
