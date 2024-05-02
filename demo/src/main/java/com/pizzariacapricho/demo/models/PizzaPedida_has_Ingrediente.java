package com.pizzariacapricho.demo.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


public class PizzaPedida_has_Ingrediente {
    @ManyToOne
    @JoinColumn(name = "id_PizzaPedida")
    private PizzaPedida pizzaPedida;

    @ManyToOne
    @JoinColumn(name = "id_Ingrediente")
    private Ingrediente ingrediente;
}
