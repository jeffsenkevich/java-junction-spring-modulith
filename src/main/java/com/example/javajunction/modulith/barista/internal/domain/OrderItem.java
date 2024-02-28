package com.example.javajunction.modulith.barista.internal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {
    private final int itemNumber;
    private final String item;
    private ItemStatus status;
}
