package com.products.interview.service.impl;

import com.products.interview.controller.dto.DtoOrder;
import com.products.interview.repository.OrderRepository;
import com.products.interview.repository.ProductRepository;
import com.products.interview.repository.entity.Order;
import com.products.interview.service.OrderService;
import com.products.interview.service.mapper.OrderMapper;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
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
    @Transactional
    public DtoOrder createOrder(final DtoOrder dtoOrder) {

        final Order order = orderMapper.mapToEntity(dtoOrder);
        order.setIdOrder(UUID.randomUUID());
        order.getProducts()
                .forEach(e -> {
                    e.setUuid(UUID.randomUUID());
                    e.setOrder(order);
                });

        return Optional.ofNullable(orderRepository.save(order))
                .map(orderMapper::mapToDto)
                .orElseThrow();

    }

    @Override
    public DtoOrder getOrderById(UUID idOrder) {
        return orderRepository.getOrderById(idOrder)
                .map(orderMapper::mapToDto)
                .orElse(null);
    }

    @Override
    public List<DtoOrder> getOrders(final String rfc) {
        if (StringUtils.hasLength(rfc)) {
            return orderRepository.getOrderByRFC(rfc).stream()
                    .map(orderMapper::mapToDto)
                    .collect(Collectors.toList());
        }

        return orderRepository.getAllOrders().stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
