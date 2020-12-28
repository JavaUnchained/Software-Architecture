package com.example.foodeliver.controller;

import com.example.foodeliver.model.dto.ClientOrderDto;
import com.example.foodeliver.model.dto.OrderResponseDTO;
import com.example.foodeliver.model.dto.Ration;
import com.example.foodeliver.model.entity.Order;
import com.example.foodeliver.service.ClientService;
import com.example.foodeliver.service.OrderService;
import com.example.foodeliver.service.RationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private RationService rationService;

    @GetMapping("/client_order")
    public List<OrderResponseDTO> clientOrder(){
        return orderService.getOrderRepository().getAllByClient_Id(clientService.getCurrentClient().getId())
                .stream().map(order -> new OrderResponseDTO(
                        order.getId(),
                        order.getRation().getRationName(),
                        order.getShippingDate().toString(),
                        order.getStatus().toString(),
                        order.getSubscrabeStatusEnum().toString(),
                        OrderService.getFullAddress(order.getAdress())
                )).collect(Collectors.toList());
    }

    @PostMapping("/client_order")
    public ResponseEntity<?> clientOrderSubmit(@RequestBody @NotNull final ClientOrderDto order) {
        if(List.of(order.getAddress(), order.getRationId(), order.getShippingDate(), order.getSubscribed())
                .stream().anyMatch(Objects::isNull)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        clientService.makeOrder(order.getRationId(), order.getAddress(),
                order.getShippingDate(), order.getSubscribed());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/rations")
    public @NotNull List<Ration> rations() {
        return rationService.getAllRations().stream().map(r -> new Ration(r.getId(), r.getRationName(),
                r.getRationDescription(), r.getPrice())).collect(Collectors.toList());
    }

    @GetMapping("/refund")
    public @NotNull List<Order> refund() {
        return orderService.getAllOrders();
    }

    @PostMapping("/refund")
    public @NotNull ResponseEntity<?> refund(@NotNull @RequestBody final Long id) {
        clientService.refund(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
