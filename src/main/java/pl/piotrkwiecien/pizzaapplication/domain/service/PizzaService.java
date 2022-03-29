package pl.piotrkwiecien.pizzaapplication.domain.service;

import org.springframework.stereotype.Service;
import pl.piotrkwiecien.pizzaapplication.data.entity.pizza.PizzaEntity;
import pl.piotrkwiecien.pizzaapplication.data.repository.PizzaRepository;
import pl.piotrkwiecien.pizzaapplication.domain.mapper.PizzaMapper;
import pl.piotrkwiecien.pizzaapplication.remote.rest.dto.request.AddPizzaDto;
import pl.piotrkwiecien.pizzaapplication.remote.rest.dto.response.PizzaDto;

import static pl.piotrkwiecien.pizzaapplication.domain.service.AuthorizationService.checkToken;

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
        checkToken(token);
        PizzaEntity pizzaEntity = pizzaMapper.mapToPizzaEntity(addPizzaDto);
        pizzaRepository.save(pizzaEntity);
    }
}
