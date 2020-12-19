package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Order;
import com.example.foodeliver.service.ClientService;
import com.example.foodeliver.service.OrderService;
import com.example.foodeliver.service.RationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private RationService rationService;

//    @GetMapping("/client_order")
//    public String clientOrder(final Model model){
//        final Client client = clientService.getCurrentClient();
//        model.addAttribute("orders", client.getOrders());
//        model.addAttribute("rations", rationService.getAllRations());
//        return "client_order";
//    }

    @PostMapping("/client_order")
    public Map<String, Object> clientOrderSubmit(@NotNull @RequestParam final String name,
                                                 @NotNull @RequestParam final String address,
                                                 @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate stripping,
                                                 @NotNull @RequestParam final Integer subscribed) {
        clientService.makeOrder(name, address, stripping, subscribed);
        final Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("orders", orderService.getAllOrders());
        modelMap.put("rations", rationService.getAllRations());
        return modelMap;
    }

    @GetMapping("/refund")
    public @NotNull List<Order> getRefund() {
        return orderService.getAllOrders();
    }

    @PostMapping("/refund")
    public @NotNull List<Order> postRefund(@NotNull @RequestParam final Long id) {
        clientService.refund(id);
        return orderService.getAllOrders();
    }
}
