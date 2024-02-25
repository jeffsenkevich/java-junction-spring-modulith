package com.example.javajunction.modulith.ledger;

import com.example.javajunction.modulith.ledger.domain.Order;
import com.example.javajunction.modulith.ledger.repo.OrderRepo;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

//    private final ApplicationEventPublisher events;
    private final OrderRepo orderRepo;

    public OrderService(ApplicationEventPublisher events, OrderRepo orderRepo) {
//        this.events = events;
        this.orderRepo = orderRepo;
    }

    public Order complete(Order order) {
//        events.publishEvent(order);
        return orderRepo.save(order);
    }

}
