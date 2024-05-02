package com.pizzariacapricho.demo.models;

import jakarta.persistence.*;

@Entity//anotação para identificar que isso é uma tabela.
public class Tamanho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tamanho;

    @Column
    private String nome;

    @Column
    private float desconto;

    public Tamanho() {
    }

    public long getId_tamanho() {
        return id_tamanho;
    }

    public void setId_tamanho(long id_tamanho) {
        this.id_tamanho = id_tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
}
