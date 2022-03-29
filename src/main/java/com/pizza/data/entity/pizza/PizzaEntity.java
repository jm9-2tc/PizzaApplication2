package com.pizza.data.entity.pizza;

import com.pizza.data.entity.pizzaSize.PizzaSizeEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pizzas")
public class PizzaEntity {
    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "pizza", orphanRemoval = true)
    private Set<PizzaSizeEntity> sizes;

    public Integer getId() {
        return id;
    }
}
