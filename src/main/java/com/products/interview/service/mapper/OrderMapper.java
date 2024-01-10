package com.products.interview.service.mapper;

import com.products.interview.controller.dto.DtoOrder;
import com.products.interview.repository.entity.Order;
import com.products.interview.utility.Constant;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constant.SPRING, uses = ProductMapper.class)
public interface OrderMapper {

    Order mapToEntity(DtoOrder dtoOrder);
    DtoOrder mapToDto(Order order);

}
