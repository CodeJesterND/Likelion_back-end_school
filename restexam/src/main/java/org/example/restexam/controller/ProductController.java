package org.example.restexam.controller;

import org.example.restexam.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    /*
     * POST /api/products : 새 상품을 등록합니다. 각 상품은 고유한 ID를 자동으로 할당 받습니다.
     * GET /api/products/{id} : 특정 ID의 상품을 조회합니다.
     * GET /api/products : 저장된 모든 상품의 목록을 조회합니다.
     * PUT /api/products/{id} : 특정 ID의 상품을 수정합니다.
     * DELETE /api/products/{id} : 특정 ID의 상품을 삭제합니다.
     */
    private final Map<Long, Product> products = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody Product product) {
        long id = counter.incrementAndGet();
        product.setId(id);
        products.put(id, product);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = products.get(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        if (!products.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        product.setId(id);
        products.put(id, product);
        return ResponseEntity.ok("Product 업데이트 성공");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        if (!products.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        products.remove(id);
        return ResponseEntity.ok("Product 삭제 성공");
    }
}