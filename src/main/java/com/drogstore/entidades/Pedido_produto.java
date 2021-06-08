package com.drogstore.entidades;

import com.drogstore.entidades.PK.PedidoProdutoPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_pedido_produto")
public class Pedido_produto implements Serializable {

    @EmbeddedId
    private PedidoProdutoPK id = new PedidoProdutoPK();
    private Integer quant_produto;
    private Double valor;

    @OneToMany
    private List<Produto> produtos;

    public Pedido_produto(){}

    public Pedido_produto(Pedido pedido, Produto produto, Integer quant_produto, Double valor){
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quant_produto = quant_produto;
        this.valor = valor;
    }

   public Pedido getPedido(){
        return id.getPedido();
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

    public Integer getQuant_produto() {
        return quant_produto;
    }

    public void setQuant_produto(Integer quant_produto) {
        this.quant_produto = quant_produto;
    }

    public Double getValor_total() {
        return valor;
    }

    public void setValor_total(Double valor) {
        this.valor = valor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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
