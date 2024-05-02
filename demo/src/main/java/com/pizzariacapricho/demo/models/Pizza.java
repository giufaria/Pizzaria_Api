package com.pizzariacapricho.demo.models;

import jakarta.persistence.*;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Pizza;

    @Column
    private String nome;

    @Column
    private float precoBase;

    @Column
    private boolean personalizada;

    public Pizza() {
    }

    public long getId_Pizza() {
        return id_Pizza;
    }

    public void setId_Pizza(long id_Pizza) {
        this.id_Pizza = id_Pizza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(float precoBase) {
        this.precoBase = precoBase;
    }

    public boolean isPersonalizada() {
        return personalizada;
    }

    public void setPersonalizada(boolean personalizada) {
        this.personalizada = personalizada;
    }
}
