package com.pizzariacapricho.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_Fornada")
    private Fornada fornada;

    @Column
    private Date dataHora;
}
