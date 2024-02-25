package com.example.javajunction.modulith.ledger.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "ORDERS")
public record Order(
        @Id Long id,
        String customerName,
        int coffeeCount,
        int latteCount
) {
}
