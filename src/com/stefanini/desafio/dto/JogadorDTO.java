package com.stefanini.desafio.dto;

import java.io.Serializable;

import com.stefanini.desafio.entities.Heroi;

public class JogadorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;

	private Heroi heroi;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Heroi getHeroi() {
		return heroi;
	}

	public void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}

}
