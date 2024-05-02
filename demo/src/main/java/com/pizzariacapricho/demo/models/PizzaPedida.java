package com.pizzariacapricho.demo.models;

import com.sun.tools.attach.AgentInitializationException;
import jakarta.persistence.*;

@Entity
public class PizzaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_PizzaPedida;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "Id_Pizza")
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "Id_Tamanho")
    private Tamanho tamanho;


    @Column
    private int quantidade;
}
