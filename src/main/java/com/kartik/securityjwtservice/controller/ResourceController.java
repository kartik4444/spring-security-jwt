package com.kartik.securityjwtservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/resource")
public class ResourceController {

    @RequestMapping("/hello")
    public ResponseEntity<String> hello()
    {
        return ResponseEntity.ok("Hello from secured endpoint!");
    }
}
