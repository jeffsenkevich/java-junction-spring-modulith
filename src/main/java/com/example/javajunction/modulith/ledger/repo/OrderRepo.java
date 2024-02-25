package com.example.javajunction.modulith.ledger.repo;

import com.example.javajunction.modulith.ledger.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> {
}
