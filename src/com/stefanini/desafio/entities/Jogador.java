package com.stefanini.desafio.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries(value = {
		@NamedQuery(name = "Jogador.findAll", query = "SELECT j FROM Jogador j ORDER BY j.id"),
		@NamedQuery(name = "Jogador.removeByID", query = "DELETE FROM Jogador j WHERE j.id = :id"),
		@NamedQuery(name = "Jogador.findByLogin", query = "SELECT j FROM Jogador j WHERE j.nickname = :nickname AND j.senha = :senha"),
		@NamedQuery(name = "Jogador.findByID", query = "SELECT j FROM Jogador j WHERE j.id = :id")
		})

@Entity
@Table(name = "jogador")
public class Jogador implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String nickname;
	@NotNull
	private String senha;

	@ManyToOne
	private Heroi heroi;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Heroi getHeroi() {
		return heroi;
	}

	public void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nickname=" + nickname + ", senha=" + senha + ", heroi=" + heroi + "]";
	}

}
