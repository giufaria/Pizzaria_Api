package com.pizzariacapricho.demo.models;
import jakarta.persistence.*;

@Entity
public class PizzaPedida_has_Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_PizzaPedidaIngrediente;
    @ManyToOne
    @JoinColumn(name = "id_PizzaPedida")
    private PizzaPedida pizzaPedida;

    @ManyToOne
    @JoinColumn(name = "id_Ingrediente")
    private Ingrediente ingrediente;

    public PizzaPedida_has_Ingrediente() {
    }

    public long getId_PizzaPedidaIngrediente() {
        return id_PizzaPedidaIngrediente;
    }

    public void setId_PizzaPedidaIngrediente(long id_PizzaPedidaIngrediente) {
        this.id_PizzaPedidaIngrediente = id_PizzaPedidaIngrediente;
    }

    public PizzaPedida getPizzaPedida() {
        return pizzaPedida;
    }

    public void setPizzaPedida(PizzaPedida pizzaPedida) {
        this.pizzaPedida = pizzaPedida;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
}
