package com.example.javajunction.modulith.barista.internal;

import com.example.javajunction.modulith.barista.internal.domain.OrderTicket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderTicketRepo {

    private final List<OrderTicket> orders = new ArrayList<>();

    public void save(OrderTicket orderTicket) {
        orders.add(orderTicket);
    }

}
