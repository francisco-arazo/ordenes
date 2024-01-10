package com.products.interview.service.impl;

import com.products.interview.controller.dto.DtoOrder;
import com.products.interview.repository.OrderRepository;
import com.products.interview.repository.ProductRepository;
import com.products.interview.repository.entity.Order;
import com.products.interview.service.OrderService;
import com.products.interview.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository,
                            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public DtoOrder createOrder(final DtoOrder dtoOrder) {

        final Order order = orderMapper.mapToEntity(dtoOrder);
        order.setIdOrder(UUID.randomUUID());

        return Optional.ofNullable(orderRepository.save(order))
                .map(orderMapper::mapToDto)
                .orElseThrow();

    }

    @Override
    public DtoOrder getOrderById(String idOrder) {
        Order order = orderRepository.getOrderById(idOrder);
        return orderMapper.mapToDto(order);

    }

    @Override
    public List<DtoOrder> getOrders() {

        final List<Order> orders = orderRepository.getAllOrders();
        final List<DtoOrder> response = new ArrayList<>();

        orders.forEach(order -> {
            DtoOrder dto = orderMapper.mapToDto(order);
            response.add(dto);

        });
        return response;

    }

    @Override
    public DtoOrder getOrderByParams(String rfc) {
        Order order = orderRepository.getOrderByRFC(rfc);
        return orderMapper.mapToDto(order);
    }
}
