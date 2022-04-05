package com.pizza.remote.rest.api;

import com.pizza.data.entity.pizza.PizzaEntity;
import com.pizza.data.repository.PizzaRepository;
import com.pizza.domain.service.PizzaService;
import com.pizza.remote.rest.dto.response.MenuDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pizza.remote.rest.dto.request.UpdatePizzaDto;
import com.pizza.remote.rest.dto.response.PizzaDto;
import com.pizza.remote.rest.dto.request.AddPizzaDto;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/api/v1/pizzas", produces = APPLICATION_JSON_VALUE)
@RestController
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public ResponseEntity<PizzaDto> addPizza(@RequestBody AddPizzaDto addPizzaDto, @RequestHeader("Access-Token") String token) {
        return ResponseEntity.ok(pizzaService.addPizza(addPizzaDto, token));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDto> updatePizza(@RequestBody UpdatePizzaDto addPizzaDto, @PathVariable("id") Integer pizzaId, @RequestHeader("Access-Token") String token) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@RequestHeader("Access-Token") String token) {
        return ResponseEntity.ok(null);
    }

    public MenuDto getMenu() {
        List<PizzaEntity> pizzaEntityList = pizzaService.pizzaRepository.findAll();
        List<PizzaDto> pizzaDtoList = pizzaEntityList.stream().map(pizzaService.pizzaMapper::mapToPizzaDto).collect(Collectors.toList());
        return null;
    }
}
