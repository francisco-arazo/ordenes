package com.products.interview.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "product")
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

}
