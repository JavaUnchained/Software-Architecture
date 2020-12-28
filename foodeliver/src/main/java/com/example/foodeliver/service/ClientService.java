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

    public void saveOrder(@NotNull final Order order) {
        orderService.getOrderRepository().save(order);
    }

    public void refund(@NotNull final Long orderId) {
        final Order order = orderService.orderById(orderId);
        final Client client = getCurrentClient();
//        client.getAccount().setBalance(client.getAccount().getBalance() + order.getRation().getPrice());
        List<Order> orders = client.getOrders();
        order.setStatus(OrderPayStatus.REFUNDABLE);
//        orderService.saveOrder(order);
        client.setOrders(orders);
        saveClient(client);
    }

    public void makeOrder(@NotNull final Integer rationId,
                          @NotNull final String address,
                          @NotNull final LocalDate stripping,
                          @NotNull final Integer subscribed) {
        final List<String> adr = Arrays.asList(address.split(","));
        final Adress adress = new Adress(adr.get(0), adr.get(1), adr.get(2), adr.get(3));
        final Ration ration = rationService.getRationRepository().getRationById(Long.valueOf(rationId));
        final SubscribeStatusEnum subscribe = subscribed > 0 ?
                SubscribeStatusEnum.SUBSCRIBE : SubscribeStatusEnum.SINGLE;
        final Order order = OrderService.getOrderOne(OrderPayStatus.PAID, adress, stripping, subscribe,ration);
        final Client client = getCurrentClient();
        final List<Order> orders = client.getOrders();
        orders.add(order);
        client.setOrders(orders);
        order.setClient(client);
        saveClient(client);
    }
    public Client getCurrentClient() {
        System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"
                + clientRepository.getClientByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        return clientRepository.getClientByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
