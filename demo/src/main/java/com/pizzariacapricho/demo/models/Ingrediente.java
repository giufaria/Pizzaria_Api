package com.pizzariacapricho.demo.models;

import jakarta.persistence.*;

@Entity
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Ingrediente;

    @Column
    private String nome;

    @Column float preco;

}
