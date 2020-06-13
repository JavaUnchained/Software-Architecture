package com.example.foodeliver.controller;

import com.example.foodeliver.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @GetMapping("/operator_order")
    public String operatorOrder(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "operator_order";
    }

//    @PostMapping("/operator_order")
//    public String rationsSumbit(@RequestParam String name,
//                                @RequestParam Double price,
//                                @RequestParam String description,
//                                Model model) {
//        Ration ration = rationService.rationFactoryMethod(name,price,description);
//        rationService.saveRation(ration);
//
//        model.addAttribute("rations", rationService.getAllRations());
//        return "operator_order";
//    }
}
