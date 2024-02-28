package com.example.javajunction.modulith.barista.internal.domain;

import lombok.Data;

import java.util.List;

@Data
public class OrderTicket {
    private final String customerName;
    private final List<OrderItem> items;
}
