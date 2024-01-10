package com.products.interview.service;

import com.products.interview.controller.dto.DtoOrder;

import java.util.List;

public interface OrderService {

    DtoOrder createOrder(DtoOrder order);
    DtoOrder getOrderById(String idOrder);

    List<DtoOrder> getOrders();

    DtoOrder getOrderByParams(String rfc);
}
