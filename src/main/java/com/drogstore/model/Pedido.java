package com.drogstore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double valor_total;
    private Date data;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(fetch =FetchType.EAGER)
    @JoinTable(name="pedido_produtos", uniqueConstraints = @UniqueConstraint(
            columnNames = {"id_pedido", "id_produto"}, name = "unique_pedido_produto"),
    joinColumns = @JoinColumn(name = "id_pedido",
            referencedColumnName = "id",
            table = "pedido", unique = false,
    foreignKey = @ForeignKey(name = "pedido_fk,", value = ConstraintMode.CONSTRAINT)),

    inverseJoinColumns = @JoinColumn(name = "produto_id", unique = false ,
            referencedColumnName = "id", updatable = false,
    table = "produto", foreignKey = @ForeignKey(name = "produto_fk", value = ConstraintMode.CONSTRAINT)))
    private List<Produto> produto;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
