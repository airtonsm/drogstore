package com.drogstore.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private String cargo;
	private String login;
	private String senha;

	@OneToMany
	private List<Pedido> pedidos;

	public Usuario(){

	}

	public Usuario(Long id, String nome, String login, String senha, String cargo) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.cargo = cargo;
	}

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
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Usuario)) return false;

		Usuario usuario = (Usuario) o;

		return getId() != null ? getId().equals(usuario.getId()) : usuario.getId() == null;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

	public List<Pedido> getPedidos(){
		return pedidos;
	}
}
