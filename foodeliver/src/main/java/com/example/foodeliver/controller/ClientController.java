package com.example.foodeliver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping("/clientpage")
    public String clientpage() {
        return "clientpage";
    }

}
