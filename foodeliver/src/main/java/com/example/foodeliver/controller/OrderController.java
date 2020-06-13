package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Adress;
import com.example.foodeliver.entity.Order;
import com.example.foodeliver.entity.Ration;
import com.example.foodeliver.entity.status.OrderPayStatus;
import com.example.foodeliver.entity.status.SubscrabeStatusEnum;
import com.example.foodeliver.entity.users.Client;
import com.example.foodeliver.entity.users.Operator;
import com.example.foodeliver.entity.users.Role;
import com.example.foodeliver.repository.ClientRepository;
import com.example.foodeliver.service.ClientService;
import com.example.foodeliver.service.OperatorService;
import com.example.foodeliver.service.OrderService;
import com.example.foodeliver.service.RationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.ElementCollection;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private RationService rationService;

    @GetMapping("/client_order")
    public String clientOrder(Model model){
        Client client = getCurrentClient();
        model.addAttribute("orders", client.getOrders());
        model.addAttribute("rations", rationService.getAllRations());
        return "client_order";
    }

    @PostMapping("/client_order")
    public String clientOrderSubmit(@RequestParam String name,
                                    @RequestParam String address,
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate shippingDate,
                                    @RequestParam Integer subscabeperiod,
                                    Model model) {

        List<String> adr = Arrays.asList(address.split(","));
        Adress adress = new Adress(adr.get(0), adr.get(1), adr.get(2), adr.get(3));
        Ration ration = rationService.getRationByName(name);

        SubscrabeStatusEnum subscrabe;
        if (subscabeperiod > 0) {
            subscrabe = SubscrabeStatusEnum.SUBSCRIBE;
        } else {
            subscrabe = SubscrabeStatusEnum.SINGLE;
        }

        Order order = orderService.orderFactoryMethod(
                OrderPayStatus.PAID, adress, shippingDate, subscrabe,ration);


        Client client = getCurrentClient();
        client.getOrders().add(order);
        clientService.saveClient(client);

        model.addAttribute("orders", client.getOrders());
        model.addAttribute("rations", rationService.getAllRations());
        return "client_order";
    }

    public Client getCurrentClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return clientService.getClientByUsername(currentPrincipalName);
    }

    public Operator getCurrentOperator() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return operatorService.getOperatorByUsername(currentPrincipalName);
    }
}
