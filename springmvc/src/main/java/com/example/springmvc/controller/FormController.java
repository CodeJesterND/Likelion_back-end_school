package com.example.springmvc.controller;

import com.example.springmvc.domain.User;
import com.example.springmvc.domain.UserForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm()); // 폼 객체를 모델에 추가
        return "form"; // 폼 뷰 반환
    }

//    @PostMapping("/submitForm")
//    public String submitForm(@RequestParam String username,
//                             @RequestParam String password) {
//        System.out.println(username + "::" + password);
//        return "result";
//    }

//    @PostMapping("/submitForm")
//    public String submitForm(@ModelAttribute User user) {
//        System.out.println(user.getUsername() + "::" + user.getPassword());
//        return "result";
//    }

    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result) {
        if (result.hasErrors()) {
            return "form"; // 유효성검사에서 에러가 발견되었다면 form.html 뷰로 리턴
        }
        return "result"; // 성공했다면, result.html 이 응답
    }
}