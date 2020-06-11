package com.example.foodeliver.controller;

import com.example.foodeliver.repository.RationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperatorController {
    @Autowired
    private RationRepository rationRepository;

    @GetMapping("/operatorpage")
    public String operatorPage() {
        return "operatorpage";
    }

    @GetMapping("/rations")
    public String rationsPage(Model model) {
        model.addAttribute("rations", rationRepository.findAll());
        return "rations";
    }

}
