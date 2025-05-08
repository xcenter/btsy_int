package com.btsy.intw.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("listUsers")
    public ResponseEntity<List<String>> listUserIds() {
        return ResponseEntity.ok(List.of("abc", "def", "ghi"));
    }
}
