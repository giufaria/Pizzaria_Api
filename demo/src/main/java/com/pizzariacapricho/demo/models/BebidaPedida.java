package com.pizzariacapricho.demo.models;

import jakarta.persistence.*;

@Entity
public class BebidaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_BebidaPedida;

    @Column
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_Bebida")
    private Bebidas bebidas;

    @ManyToOne
    @JoinColumn(name = "id_Pedido")
    private Pedido pedido;

    public BebidaPedida() {
    }

    public long getId_BebidaPedida() {
        return id_BebidaPedida;
    }

    public void setId_BebidaPedida(long id_BebidaPedida) {
        this.id_BebidaPedida = id_BebidaPedida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Bebidas getBebidas() {
        return bebidas;
    }

    public void setBebidas(Bebidas bebidas) {
        this.bebidas = bebidas;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
