package com.pizzariacapricho.demo.models;

import jakarta.persistence.*;

@Entity
public class Fornada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Fornada;

    @Column
    private int numFornada;

    @Column
    private int qtdPizzas;
}
