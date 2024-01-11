package com.products.interview.controller.impl;

import com.products.interview.controller.dto.DtoOrder;
import com.products.interview.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stores/v0")
public class ProductController {

    private OrderService orderService;

    public ProductController(OrderService productService) {
        this.orderService = productService;
    }

    @PostMapping("/orders")
    public ResponseEntity<DtoOrder> createOrder(final @Valid @RequestBody DtoOrder order) {
        final DtoOrder orderResponse = orderService.createOrder(order);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<DtoOrder> getOrderById(@PathVariable(name = "id") final UUID idOrden) {
        return ResponseEntity.ok(orderService.getOrderById(idOrden));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<DtoOrder>>getOrders(@RequestParam(name = "rfc", required = false) final String rfc){
        final List<DtoOrder> orders = orderService.getOrders(rfc);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
