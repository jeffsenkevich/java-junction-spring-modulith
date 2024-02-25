package com.example.javajunction.modulith.barista;

import com.example.javajunction.modulith.ledger.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class OrderHistory {

    private static final Logger log = LoggerFactory.getLogger(OrderHistory.class);

    @TransactionalEventListener
    void on(Order order) {
        log.info("new order: {}", order);
    }

}
