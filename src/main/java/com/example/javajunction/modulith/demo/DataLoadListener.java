package com.example.javajunction.modulith.demo;

import com.example.javajunction.modulith.ledger.domain.Order;
import com.example.javajunction.modulith.pointofsale.PaymentTerminal;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

//@Component
public class DataLoadListener implements ApplicationListener<ApplicationReadyEvent> {

    private final PaymentTerminal paymentTerminal;

    public DataLoadListener(PaymentTerminal paymentTerminal) {
        this.paymentTerminal = paymentTerminal;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Order order1 = new Order(null, "Arthur Dent", 0, 1);
        paymentTerminal.placeOrder(order1);

        Order order2 = new Order(null, "Ford Prefect", 2, 0);
        paymentTerminal.placeOrder(order2);
    }

}
