package com.products.interview.repository.entity;

import com.products.interview.controller.dto.DtoProduct;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "orders")
public class Order {

    @Id
    @Column(name = "id_order")
    private UUID idOrder;
    @Column(name = "name_client")
    private String nameClient;
    @Column(name = "name_store")
    private String nameStore;
    @Column(name = "rfc_client")
    private String rfcClient;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

}
