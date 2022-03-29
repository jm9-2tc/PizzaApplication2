package com.pizza.data.entity.pizzaSize;

import com.pizza.data.entity.orderSize.OrderSizeEntity;
import com.pizza.data.entity.pizza.PizzaEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "pizzas_sizes")
public class PizzaSizeEntity {
    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public void setPriceBase(BigDecimal priceBase) {
        this.priceBase = priceBase;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "size_type")
    private String sizeType;

    @Column(name = "price_base")
    private BigDecimal priceBase;

    @Column(name = "pizza_id")
    private Integer pizzaId;


    @OneToMany(mappedBy = "pizzas_sizes")
    private Set<OrderSizeEntity> orderSizes;

    @ManyToOne
    @JoinColumn(name = "pizza_id", insertable = false, updatable = false)
    private PizzaEntity pizza;
}
