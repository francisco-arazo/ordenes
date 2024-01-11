package com.products.interview.repository;

import com.products.interview.repository.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, String> {

    @Query(value = "SELECT * FROM ORDERS", nativeQuery = true)
    List<Order> getAllOrders();

    @Query(value = "SELECT * FROM ORDERS WHERE id_order = :orderId", nativeQuery = true)
    Optional<Order> getOrderById(@Param("orderId") UUID orderId);

    @Query(value = "SELECT * FROM ORDERS WHERE rfc_client = :rfc", nativeQuery = true)
    List<Order> getOrderByRFC(@Param("rfc") String rfc);
}
