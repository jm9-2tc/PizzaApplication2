package com.pizza.domain.mapper;

import com.pizza.data.entity.pizzaSize.PizzaSizeEntity;
import com.pizza.domain.model.SizeType;
import com.pizza.remote.rest.dto.request.AddSizeDto;
import com.pizza.remote.rest.dto.response.SizeDto;

import java.util.List;
import java.util.stream.Collectors;

public class SizeMapper {
    public PizzaSizeEntity mapToSizeEntity(AddSizeDto addSizeDto, Integer id){
        PizzaSizeEntity pizzaSizeEntity = new PizzaSizeEntity();

        pizzaSizeEntity.setPizzaId(id);
        pizzaSizeEntity.setSizeType(addSizeDto.getSize().name());
        pizzaSizeEntity.setPriceBase(addSizeDto.getPrice());

        return pizzaSizeEntity;
    }

    public SizeDto mapToSizeDto(PizzaSizeEntity sizeEntity) {
        return new SizeDto(sizeEntity.getId(), SizeType.valueOf(sizeEntity.getSizeType()), sizeEntity.getPriceBase());
    }
}
