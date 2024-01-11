package com.products.interview.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "order_detail")
public class Product {

    @Id
    @Column(name = "id_product")
    private UUID uuid;
    @Column(name = "product_code")
    private Integer productCode;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "amount")
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "product_order", nullable = false)
    private Order order;

}
