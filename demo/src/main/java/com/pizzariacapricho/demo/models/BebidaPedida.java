package com.pizzariacapricho.demo.models;

import jakarta.persistence.*;

@Entity
public class BebidaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Bebida;

    @Column
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
