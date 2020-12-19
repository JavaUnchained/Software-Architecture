package com.example.foodeliver.controller;

import com.example.foodeliver.model.dto.ClientOrderDto;
import com.example.foodeliver.model.entity.Order;
import com.example.foodeliver.model.entity.users.Client;
import com.example.foodeliver.service.ClientService;
import com.example.foodeliver.service.OrderService;
import com.example.foodeliver.service.RationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/client_order")
    public Map<String, Object> clientOrder(){
        final Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("orders", orderService.getOrderRepository()
                .getAllByClient_Name(clientService.getCurrentClient().getName()));
        modelMap.put("rations", rationService.getAllRations());
        return modelMap;
    }

    @PostMapping("/client_order")
    public ResponseEntity<?> clientOrderSubmit(@RequestBody @NotNull final ClientOrderDto order) {
        if(!order.isAllFieldNonNull()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        clientService.makeOrder(order.getName(), order.getAddress(), order.getStripping(), order.getSubscribed());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/refund")
    public @NotNull List<Order> refund() {
        return orderService.getAllOrders();
    }

    @PostMapping("/refund")
    public @NotNull ResponseEntity<?> refund(@NotNull @RequestParam final Long id) {
        clientService.refund(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
