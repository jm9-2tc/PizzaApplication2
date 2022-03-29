package com.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pizza.data.entity.pizza.PizzaEntity;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {

}
