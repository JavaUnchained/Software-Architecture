package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Ration;
import com.example.foodeliver.repository.RationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RationController {
    @Autowired
    private RationRepository rationRepository;

    @GetMapping("/rations")
    public String rations(Model model) {
        model.addAttribute("rations", rationRepository.findAll());
        return "rations";
    }

    @PostMapping("/rations")
    public String rationsSumbit(@ModelAttribute Ration ration) {
        return "result";
    }
}
