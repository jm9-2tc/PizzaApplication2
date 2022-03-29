package com.pizza.data.repository;

import com.pizza.data.entity.pizzaSize.PizzaSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<PizzaSizeEntity, Integer> {

}
