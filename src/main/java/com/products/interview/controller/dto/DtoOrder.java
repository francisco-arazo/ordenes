package com.products.interview.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class DtoOrder implements Serializable {

    @NotEmpty
    private String nameClient;
    @NotEmpty
    private String nameStore;
    @NotEmpty
    private String rfcClient;
    @NotNull
    private List<DtoProduct> products;

}
