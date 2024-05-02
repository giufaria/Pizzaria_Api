package com.pizzariacapricho.demo.models;

import jakarta.persistence.*;

@Entity
public class Bebidas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Bebida;

    @Column
    private String nome;

    @Column
    private float preco;

    public Bebidas() {
    }

    public long getId_Bebida() {
        return id_Bebida;
    }

    public void setId_Bebida(long id_Bebida) {
        this.id_Bebida = id_Bebida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
