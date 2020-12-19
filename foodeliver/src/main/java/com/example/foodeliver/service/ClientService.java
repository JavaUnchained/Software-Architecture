package com.example.foodeliver.service;

import com.example.foodeliver.model.entity.Adress;
import com.example.foodeliver.model.entity.Order;
import com.example.foodeliver.model.entity.Ration;
import com.example.foodeliver.model.entity.status.OrderPayStatus;
import com.example.foodeliver.model.entity.status.SubscribeStatusEnum;
import com.example.foodeliver.model.entity.users.Client;
import com.example.foodeliver.model.repository.ClientRepository;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@Getter
@Setter
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RationService rationService;


    public void saveClient(@NotNull final Client client) {
        clientRepository.save(client);

    }

//    @NotNull
//    public Client getCurrentClient() {
//        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        final String currentPrincipalName = authentication.getName();
//        return getClientByUsername(currentPrincipalName);
//    }

    public Client getClientByUsername(@NotNull final String username) {
        return clientRepository.getClientByUsername(username);
    }

    public void refund(@NotNull final Long orderId) {
        final Order order = orderService.orderById(orderId);
//        final Client client = getCurrentClient();
//        client.getAccount().setBalance(client.getAccount().getBalance() + order.getRation().getPrice());
//        saveClient(client);

        order.setStatus(OrderPayStatus.REFUNDABLE);
        orderService.saveOrder(order);
    }

    public void makeOrder(@NotNull final String name,
                          @NotNull final String address,
                          @NotNull final LocalDate stripping,
                          @NotNull final Integer subscribed) {
        final List<String> adr = Arrays.asList(address.split(","));
        final Adress adress = new Adress(adr.get(0), adr.get(1), adr.get(2), adr.get(3));
        final Ration ration = rationService.getRationByName(name);
        final SubscribeStatusEnum subscribe = subscribed > 0 ?
                SubscribeStatusEnum.SUBSCRIBE : SubscribeStatusEnum.SINGLE;
//        final Order order = OrderService.getOrderOne(OrderPayStatus.PAID, adress, stripping, subscribe,ration);
//        final Client client = getCurrentClient();
//        final Double balance  = client.getAccount().getBalance() - ration.getPrice();
//        final List<Order> orders = client.getOrders();
//        orders.add(order);

//        client.getAccount().setBalance(balance);
//        client.setOrders(orders);
//        saveClient(client);
    }
    public Client getCurrentClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return clientRepository.getClientByUsername(authentication.getName());
    }

}
