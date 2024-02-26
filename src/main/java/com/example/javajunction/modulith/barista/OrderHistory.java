package com.example.javajunction.modulith.barista;

import com.example.javajunction.modulith.ledger.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class OrderHistory {

    private static final Logger log = LoggerFactory.getLogger(OrderHistory.class);

    @ApplicationModuleListener
    void on(Order order) {
        var message = String.format("\nCustomer: %s\n\t%d coffee(s)\n\t%d latte(s)", order.customerName(), order.coffeeCount(), order.latteCount());
        log.info(message);
    }

}
