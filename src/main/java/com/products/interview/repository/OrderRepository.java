package com.products.interview.repository;

import com.products.interview.repository.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, String> {

    @Query(value = "SELECT * FROM ORDER", nativeQuery = true)
    List<Order> getAllOrders();

    @Query(value = "SELECT * FROM ORDER WHERE id_order = :orderId", nativeQuery = true)
    Order getOrderById(@Param("orderId") String orderId);

    @Query(value = "SELECT * FROM ORDER WHERE rfc = :rfc", nativeQuery = true)
    Order getOrderByRFC(@Param("rfc") String rfc);
}
