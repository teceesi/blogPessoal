package com.farm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name= "tb_produtos")
public class ProdutosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 3, max = 45)
	private String nome;
	@NotNull
	private float preco;
	@NotNull
	private boolean receita;
	
	@NotNull 
	@ManyToOne
	@JsonIgnoreProperties("tb_produtos")
	@JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private CategoriaModel categoria;
	
	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isReceita() {
		return receita;
	}

	public void setReceita(boolean receita) {
		this.receita = receita;
	}


	
	
}
