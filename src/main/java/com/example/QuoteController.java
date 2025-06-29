package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    @GetMapping("/api/quote")
    public String getQuote() {
        return "DevOps is culture.";
    }
}
