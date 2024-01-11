package com.products.interview.service;

import com.products.interview.controller.dto.DtoOrder;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    DtoOrder createOrder(DtoOrder order);
    DtoOrder getOrderById(UUID idOrder);
    List<DtoOrder> getOrders(String rfc);
}
