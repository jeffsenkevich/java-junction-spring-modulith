package com.example.javajunction.modulith.barista.internal;

import com.example.javajunction.modulith.barista.internal.domain.OrderItem;
import com.example.javajunction.modulith.barista.internal.domain.OrderTicket;
import com.example.javajunction.modulith.barista.internal.service.OrderMapper;
import com.example.javajunction.modulith.ledger.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderHistory {

    private static final Logger log = LoggerFactory.getLogger(OrderHistory.class);

    private final OrderMapper orderMapper;
    private final List<OrderTicket> orders = new ArrayList<>();

    public OrderHistory(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @ApplicationModuleListener
    void on(Order order) {
        orders.add(orderMapper.mapOrderEventToOrderTicket(order));
    }

    @Scheduled(fixedDelay = 30, initialDelay = 1,timeUnit = TimeUnit.SECONDS)
    void printOrders() {
        StringBuilder orderDisplay = new StringBuilder();
        for (OrderTicket orderTicket : orders) {
            String customerName = orderTicket.getCustomerName();
            int totalItems = orderTicket.getItems().size();

            for (OrderItem item : orderTicket.getItems()) {
                orderDisplay.append(String.format("\nCustomer: %s (%d of %d)\t%s\n\t%s", customerName, item.getItemNumber(), totalItems, item.getStatus(), item.getItem()));
            }
        }

        log.info(orderDisplay.toString());
    }

}
