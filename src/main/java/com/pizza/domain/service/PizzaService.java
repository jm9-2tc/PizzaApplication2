package com.pizza.domain.service;

import com.pizza.data.entity.pizzaSize.PizzaSizeEntity;
import com.pizza.data.repository.SizeRepository;
import com.pizza.domain.mapper.SizeMapper;
import com.pizza.remote.rest.dto.request.AddSizeDto;
import org.springframework.stereotype.Service;
import com.pizza.data.entity.pizza.PizzaEntity;
import com.pizza.data.repository.PizzaRepository;
import com.pizza.domain.mapper.PizzaMapper;
import com.pizza.remote.rest.dto.request.AddPizzaDto;
import com.pizza.remote.rest.dto.response.PizzaDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {
    public final PizzaRepository pizzaRepository;
    public final SizeRepository sizeRepository;
    public final PizzaMapper pizzaMapper;
    public final SizeMapper sizeMapper;

    public PizzaService(PizzaRepository pizzaRepository, SizeRepository sizeRepository, PizzaMapper pizzaMapper, SizeMapper sizeMapper) {
        this.pizzaRepository = pizzaRepository;
        this.sizeRepository = sizeRepository;
        this.pizzaMapper = pizzaMapper;
        this.sizeMapper = sizeMapper;
    }

    public PizzaDto addPizza(AddPizzaDto addPizzaDto, String token){
        AuthorizationService.checkToken(token);
        PizzaEntity pizzaEntity = pizzaMapper.mapToPizzaEntity(addPizzaDto);
        pizzaRepository.save(pizzaEntity);

        List<AddSizeDto> addSizeDtoList = addPizzaDto.getSizes();
        List<PizzaSizeEntity> pizzaSizeEntityList = addSizeDtoList
                .stream()
                .map(addSizeDto -> sizeMapper.mapToSizeEntity(addSizeDto, pizzaEntity.getId()))
                .collect(Collectors.toList());

        sizeRepository.saveAll(pizzaSizeEntityList);
        return null;
    }
}
