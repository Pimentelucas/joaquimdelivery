package com.generation.joaquimdelivery.model;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_restaurantes")
public class RestauranteModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="O campo Nome deve ser preenchido!")
	@Size(min=10,max=100,message="O campo nome deve ter no mínimo 10 e no máximo 100 caracteres.")
	private String nome;
	
	@Size(min=10,max=100,message="O campo Horário de Funcionamento deve ter no mínimo 10 e no máximo 100 caracteres.")
	private String horario_funcionamento;
	
	@Range(min=1,max=10,message="A nota deve ser um número inteiro de 1 a 10!")
	private Integer avaliacao;
	
	@Size(min=10,max=100,message="O campo Endereço deve ter no mínimo 10 e no máximo 100 caracteres.")
	private String endereco;
	
	@NotNull(message="O campo Saudavel não pode ser nulo e deve ser preenchido com 'true' ou 'false'")
	private Boolean saudavel;
	
	public Boolean getSaudavel() {
		return saudavel;
	}

	@ManyToOne
	@JsonIgnoreProperties("restaurante")
	private CategoriaModel categoria;

	public Long getId() {
		return id;
	}
	
	public void setSaudavel(Boolean saudavel) {
		this.saudavel = saudavel;
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

	public String getHorario_funcionamento() {
		return horario_funcionamento;
	}

	public void setHorario_funcionamento(String horario_funcionamento) {
		this.horario_funcionamento = horario_funcionamento;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
