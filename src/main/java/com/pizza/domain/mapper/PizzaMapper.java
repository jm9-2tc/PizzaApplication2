package com.pizza.domain.mapper;

import com.pizza.data.entity.pizzaSize.PizzaSizeEntity;
import com.pizza.remote.rest.dto.response.PizzaDto;
import com.pizza.remote.rest.dto.response.SizeDto;
import org.springframework.stereotype.Component;
import com.pizza.data.entity.pizza.PizzaEntity;
import com.pizza.remote.rest.dto.request.AddPizzaDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PizzaMapper {
    private final SizeMapper sizeMapper;

    public PizzaMapper(SizeMapper sizeMapper) {
        this.sizeMapper = sizeMapper;
    }

    public PizzaEntity mapToPizzaEntity(AddPizzaDto addPizzaDto){
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(addPizzaDto.getName());
        return pizzaEntity;
    }

    public PizzaDto mapToPizzaDto(PizzaEntity pizzaEntity) {
        List<SizeDto> sizeDtoList = pizzaEntity.getSizes().stream().map(PizzaSizeEntity::getSizeType).collect(Collectors.toList());
        return new PizzaDto(pizzaEntity.getId(), pizzaEntity.getName(), sizeDtoList);
    }
}
