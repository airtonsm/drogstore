package com.drogstore.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Estoque implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int quantidade;

    @OneToOne
    private Produto produto;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
