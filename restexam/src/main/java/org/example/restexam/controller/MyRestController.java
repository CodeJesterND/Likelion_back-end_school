package org.example.restexam.controller;

import org.example.restexam.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {
    // GET 요청 처리 예제
    @GetMapping("/api/greeting")
    public Map<String, String> greet(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name + "!");
        return response;
    }

    @GetMapping(value = "/productjson/{id}", produces = "application/json")
    public Product getProductAsJson(@PathVariable Long id) {
        // 데이터베이스에서 제품 조회 로직
        return new Product(id, "Example Product", 9.99);
    }

    @GetMapping(value = "/productxml/{id}", produces = "application/xml")
    public Product getProductAsXml(@PathVariable Long id) {
        // 데이터베이스에서 제품 조회 로직
        return new Product(id, "Example Product", 9.99);
    }
}
