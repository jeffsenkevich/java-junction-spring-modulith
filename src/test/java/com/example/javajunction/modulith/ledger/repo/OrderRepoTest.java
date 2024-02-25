package com.example.javajunction.modulith.ledger.repo;

import com.example.javajunction.modulith.ledger.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
class OrderRepoTest {

    @Autowired
    private OrderRepo orderRepo;

    @Test
    void testSave() {
        Order order1 = new Order(null, "foo1", 1, 0);
        Order order2 = new Order(null, "foo2", 0, 1);

        orderRepo.saveAll(Arrays.asList(order1, order2));

        Iterable<Order> orders = orderRepo.findAll();

        assertThat(orders).hasSize(2);
    }

}