package com.example.javajunction.modulith.barista.internal.service;

import com.example.javajunction.modulith.barista.internal.domain.ItemStatus;
import com.example.javajunction.modulith.barista.internal.domain.OrderItem;
import com.example.javajunction.modulith.barista.internal.domain.OrderTicket;
import com.example.javajunction.modulith.ledger.domain.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderMapper {

    public OrderTicket mapOrderEventToOrderTicket(Order order) {
        AtomicInteger itemNumber = new AtomicInteger(0);
        ArrayList<OrderItem> items = new ArrayList<>();

        // coffees
        for (int itemCount = 0 ; itemCount < order.coffeeCount() ; itemCount++) {
            items.add(new OrderItem(itemNumber.incrementAndGet(), "Coffee", ItemStatus.PENDING));
        }

        // lattes
        for (int itemCount = 0 ; itemCount < order.latteCount() ; itemCount++) {
            items.add(new OrderItem(itemNumber.incrementAndGet(), "Latte", ItemStatus.PENDING));
        }

        return new OrderTicket(order.customerName(), items);
    }

}
