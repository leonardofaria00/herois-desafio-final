package com.stefanini.desafio.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.stefanini.desafio.dto.JogadorDTO;
import com.stefanini.desafio.entities.Heroi;
import com.stefanini.desafio.entities.Jogador;
import com.stefanini.desafio.parsers.JogadorParser;
import com.stefanini.desafio.persistence.HeroiDAO;
import com.stefanini.desafio.persistence.JogadorDAO;
import com.stefanini.desafio.rest.exceptions.NegocioException;

public class JogadorService {

	@Inject
	Jogador jogador;

	@Inject
	JogadorParser dto;

	@Inject
	JogadorDAO dao;

	@Inject
	HeroiDAO hdao;

	public JogadorDTO getJogadorByID(Jogador jogador) throws NegocioException {// Inspecionado

		if (jogador.getNickname().isEmpty() || jogador.getSenha().isEmpty()) {
			throw new NegocioException("Campo vazio, informe seu login e senha!");
		}

		try {
			System.out.println("Nome do jogador: " + jogador.getNickname());
			System.out.println("Senha do jogador: " + jogador.getSenha());

			return dto.toDTO(dao.getLogin(jogador.getNickname(), jogador.getSenha()));
		} catch (NoResultException e) {
			throw new NegocioException("Ops! Seu nickname ou senha estão incorretos!");
		}
	}

	public List<JogadorDTO> getJogadores() throws NegocioException {// Inspecionado
		if (dao.getJogadores().isEmpty()) {
			throw new NegocioException("Nao existe jogador cadastrado!");
		}
		return dto.toDTO(dao.getJogadores());
	}

	public void cadastrar(Jogador jogador) throws NegocioException {
		
		boolean contains = dao.getJogadores().contains(jogador);// Ajustar verificação
		if (contains) {
			throw new NegocioException("Nickname ja cadastrado, informe outro!");
		}
		
		if (jogador.getSenha().length() < 6 || jogador.getSenha().length() > 8) {
			throw new NegocioException("Informe uma senha entre 6 a 8 caracteres.");
		}
		dao.cadastrar(jogador);
	}

	public Jogador vincularJogadoEHeroi(Integer id_jogador, Integer id_heroi) throws NegocioException {// Inspecionado

		Jogador jogador = dao.getJogadorByID(id_jogador);
		Heroi heroi = hdao.getHeroiByID(id_heroi);

		if (jogador.getHeroi() != null && jogador.getHeroi().getId() != null)
			throw new NegocioException("Jogador " + jogador.getNickname() + " já tem um Herói cadastrado");

		jogador.setHeroi(heroi);
		dao.update(jogador);

		return jogador;
	}
}
