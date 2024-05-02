package com.pizzariacapricho.demo.models;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Cliente;

    @Column
    private String nome;

    @Column
    private String telefone;

    @Column
    private String endereco;

    @Column
    private String login;

    @Column
    private String senha;

    public Cliente() {
    }

    public long getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(long id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
