package com.stefanini.desafio.service;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.stefanini.desafio.dto.JogadorDTO;
import com.stefanini.desafio.entities.Jogador;
import com.stefanini.desafio.parsers.JogadorParser;
import com.stefanini.desafio.persistence.JogadorDAO;
import com.stefanini.desafio.rest.exceptions.NegocioException;

public class JogadorService {

	@Inject
	JogadorParser dto;

	@Inject
	JogadorDAO dao;

	public JogadorDTO getJogadorByID(Jogador jogador) throws NegocioException {

//		if (jogador.getNickname() == null || jogador.getSenha() == null) {
//			throw new NegocioException("Informe um login e uma senha válida!");
//		}
//		if (jogador.getNickname().isEmpty() || jogador.getSenha().isEmpty()) {
//			throw new NegocioException("Campo vazio!");
//		}
		try {
			System.out.println("Nome do jogador: " + jogador.getNickname());
			System.out.println("Senha do jogador: " + jogador.getSenha());

//			System.out.println(jogador.getHeroi().getNome());
			return dto.toDTO(dao.getLogin(jogador.getNickname(), jogador.getSenha()));
		} catch (NoResultException e) {
			throw new NegocioException("Ops! Seu nickname ou senha estão incorretos!");
		}
	}
}
