package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Ration;
import com.example.foodeliver.repository.RationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String rationsSumbit(@RequestParam String name,
                                @RequestParam Double price,
                                @RequestParam String description,
                                Model model) {
        Ration ration = new Ration(name,description,price);
        rationRepository.save(ration);
        model.addAttribute("rations", rationRepository.findAll());
        return "rations";
    }
}
