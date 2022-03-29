package com.pizza.domain.mapper;

import com.pizza.data.entity.pizzaSize.PizzaSizeEntity;
import com.pizza.remote.rest.dto.request.AddSizeDto;

public class SizeMapper {
    public PizzaSizeEntity mapToSizeEntity(AddSizeDto addSizeDto, Integer id){
        PizzaSizeEntity pizzaSizeEntity = new PizzaSizeEntity();

        pizzaSizeEntity.setPizzaId(id);
        pizzaSizeEntity.setSizeType(addSizeDto.getSize().name());
        pizzaSizeEntity.setPriceBase(addSizeDto.getPrice());

        return pizzaSizeEntity;
    }
}
