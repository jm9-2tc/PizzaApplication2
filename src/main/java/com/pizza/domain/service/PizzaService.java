package com.pizza.domain.service;

import org.springframework.stereotype.Service;
import com.pizza.data.entity.pizza.PizzaEntity;
import com.pizza.data.repository.PizzaRepository;
import com.pizza.domain.mapper.PizzaMapper;
import com.pizza.remote.rest.dto.request.AddPizzaDto;
import com.pizza.remote.rest.dto.response.PizzaDto;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final SizeRepository sizeRepository;
    private final PizzaMapper pizzaMapper;
    private final SizeMapper sizeMapper;

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
    }
}
