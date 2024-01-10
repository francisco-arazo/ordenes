package com.products.interview.repository.entity;

import com.products.interview.controller.dto.DtoProduct;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "order")
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
    @Column(name = "product")
    private DtoProduct product;

}
