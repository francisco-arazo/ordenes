package com.products.interview.controller.impl;

import com.products.interview.controller.dto.DtoOrder;
import com.products.interview.service.OrderService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedidos/v0")
public class ProductController {

    private OrderService orderService;

    public ProductController(OrderService productService) {
        this.orderService = productService;
    }

    @PostMapping("/orden")
    public ResponseEntity<DtoOrder> createOrder(final @Valid @RequestBody DtoOrder order) {

        final DtoOrder orderResponse = orderService.createOrder(order);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);

    }

    @GetMapping("/orden/{id}")
    public ResponseEntity<DtoOrder> getOrderById(@PathVariable(name = "id") final String idOrden) {
        return ResponseEntity.ok(orderService.getOrderById(idOrden));

    }

    @GetMapping("/orden")
    public ResponseEntity<DtoOrder> getOrderByParams(@RequestParam(name = "rfc", required = true) final String rfc){
        return ResponseEntity.ok(orderService.getOrderByParams(rfc));

    }

    @GetMapping("/ordenes")
    public ResponseEntity<List<DtoOrder>>getOrders(){
        final List<DtoOrder> orders = orderService.getOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
