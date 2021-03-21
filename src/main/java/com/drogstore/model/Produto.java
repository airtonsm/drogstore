package com.drogstore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Double preco;
    private int quant_estoque;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "produtos")
    private List<Pedido> pedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuant_estoque() {
        return quant_estoque;
    }

    public void setQuant_estoque(int quant_estoque) {
        this.quant_estoque = quant_estoque;
    }

}
