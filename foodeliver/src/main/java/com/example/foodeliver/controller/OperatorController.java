package com.example.foodeliver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperatorController {
    @GetMapping("/operatorpage")
    public String operatorpage() {
        return "operatorpage";
    }


}
