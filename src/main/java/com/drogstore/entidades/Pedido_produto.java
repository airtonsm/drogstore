package com.drogstore.entidades;

import com.drogstore.entidades.PK.PedidoProdutoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_pedidoProduto")
public class Pedido_produto implements Serializable {

    @EmbeddedId
    private PedidoProdutoPK id = new PedidoProdutoPK();

    private Integer quantidade;
    private Double valor;

    public Pedido_produto(){}

    public Pedido_produto(Pedido pedido, Produto produto, Integer quantidade, Double valor){
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.valor = valor;
    }

    @JsonIgnore
    public Pedido getPedido(){
        return  id.getPedido(); // retorna o id do pedido que foi instanciado no construtor
    }

    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido_produto that = (Pedido_produto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
