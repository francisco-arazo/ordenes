package com.products.interview.service.mapper;

import com.products.interview.controller.dto.DtoProduct;
import com.products.interview.repository.entity.Product;
import com.products.interview.utility.Constant;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constant.SPRING)
public interface ProductMapper {

    DtoProduct mapToDto(Product product);

    Product mapToEntity(DtoProduct dto);
}
