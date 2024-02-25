package com.example.javajunction.modulith.pointofsale;

import com.example.javajunction.modulith.ledger.OrderService;
import com.example.javajunction.modulith.ledger.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class PaymentTerminal {

    private final OrderService orderService;

    public PaymentTerminal(OrderService orderService) {
        this.orderService = orderService;
    }

    public void placeOrder(Order order) {
        orderService.complete(order);
    }

}
