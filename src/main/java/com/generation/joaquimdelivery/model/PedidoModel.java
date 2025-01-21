package com.generation.joaquimdelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_pedidos")
public class PedidoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo pedido é obrigatório!")
	@Size(min = 5, max = 30, message = "O atributo pedido deve conter no mínimo 05 e no máximo 30 caracteres")
	private String produto;
	
	@ManyToOne
	@JsonIgnoreProperties("pedido")
	private UsuarioModel usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("pedido")
	private RestauranteModel restaurante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public RestauranteModel getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteModel restaurante) {
		this.restaurante = restaurante;
	}
	
	
}
