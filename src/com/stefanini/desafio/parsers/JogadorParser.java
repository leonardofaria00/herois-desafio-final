package com.stefanini.desafio.parsers;

import com.stefanini.desafio.dto.JogadorDTO;
import com.stefanini.desafio.entities.Heroi;
import com.stefanini.desafio.entities.Jogador;

public class JogadorParser extends AbstractParser<JogadorDTO, Jogador> {

	@Override
	public JogadorDTO toDTO(Jogador jogador) {
		JogadorDTO dto = new JogadorDTO();
		dto.setId(jogador.getId());
		dto.setNome(jogador.getNickname());
		
		
		if (jogador.getHeroi() != null) {
			dto.setHeroi(jogador.getHeroi());
		}
		return dto;
	}

	@Override
	public Jogador toEntity(JogadorDTO dto) {
		Jogador jogador = new Jogador();
		jogador.setId(dto.getId());
		jogador.setNickname(dto.getNome());
		jogador.setHeroi(new Heroi());
		jogador.getHeroi().setId(dto.getHeroi().getId());
		jogador.getHeroi().setNome(dto.getHeroi().getNome());
		jogador.getHeroi().setAtaque(dto.getHeroi().getAtaque());
		jogador.getHeroi().setDefesa(dto.getHeroi().getDefesa());
		jogador.getHeroi().setForca(dto.getHeroi().getForca());
		jogador.getHeroi().setInteligencia(dto.getHeroi().getInteligencia());
		jogador.getHeroi().setPoder(dto.getHeroi().getPoder());
		jogador.getHeroi().setVelocidade(dto.getHeroi().getVelocidade());
		jogador.getHeroi().setVida(dto.getHeroi().getVida());

		return jogador;
	}

}
