package com.stefanini.desafio.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "heroi")
@NamedQueries({ 
	@NamedQuery(name = "Heroi.getAll", query = "SELECT h FROM Heroi h"),
	@NamedQuery(name = "Heroi.findByID", query = "SELECT h FROM Heroi h WHERE h.id = :id")
	})
public class Heroi implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;	
	private String nome;
	private Integer ataque;
	private Integer defesa;
	private Integer inteligencia;
	private Integer poder;
	private Integer velocidade;
	private Integer forca;
	private Integer vida;

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPoder() {
		return poder;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}

	public Integer getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}

	public Integer getForca() {
		return forca;
	}

	public void setForca(Integer forca) {
		this.forca = forca;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	@Override
	public String toString() {
		return "Heroi [id=" + id + ", nome=" + nome + ", ataque=" + ataque + ", defesa=" + defesa + ", inteligencia="
				+ inteligencia + ", poder=" + poder + ", velocidade=" + velocidade + ", forca=" + forca + ", vida="
				+ vida + "]";
	}

}
