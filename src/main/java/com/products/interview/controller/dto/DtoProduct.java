package com.products.interview.controller.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
public class DtoProduct implements Serializable {

    @NotEmpty
    private String productCode;
    @NotEmpty
    private String productName;
    @NotNull
    private Double amount;

}
