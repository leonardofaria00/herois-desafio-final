package com.stefanini.desafio.service;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import com.stefanini.desafio.entities.Heroi;
import com.stefanini.desafio.entities.Jogador;
import com.stefanini.desafio.parsers.JogadorParser;
import com.stefanini.desafio.persistence.HeroiDAO;
import com.stefanini.desafio.persistence.JogadorDAO;
import com.stefanini.desafio.rest.exceptions.NegocioException;

public class BatalhaService {
	@Inject
	Jogador jogador;

	@Inject
	JogadorParser parser;

	@Inject
	JogadorDAO dao;

	@Inject
	HeroiDAO hdao;

	public String batalhar(Integer id) throws NegocioException {
		try {

			List<Heroi> herois = hdao.getHerois();
			Random gerador = new Random();
			int inimigo = gerador.nextInt(herois.size());
			Heroi oponente = hdao.getHeroiByID(inimigo);

			Jogador jogador = dao.getJogadorByID(id);

			String vencedor = null;

			// Dados do jogador
			String jogadorNome = jogador.getHeroi().getNome();
			System.out.println("Nome do Jogador: " + jogadorNome);

			Integer jogadorAtaque = jogador.getHeroi().getAtaque();
			System.out.println("Ataque do Jogador: " + jogadorAtaque);

			Integer jogadorPoder = jogador.getHeroi().getPoder() + new Random().nextInt(100);
			System.out.println("Poder do Jogador: " + jogadorPoder);

			Integer jogadorDefesa = jogador.getHeroi().getDefesa();
			System.out.println("Defesa do Jogador: " + jogadorDefesa);

			Integer jogadorVida = jogador.getHeroi().getVida();
			System.out.println("Vida do Jogador: " + jogadorVida);
			System.out.println();

			// Dados do Herói aleatório
			String oponenteNome = oponente.getNome();
			System.out.println("Nome do Oponente: " + oponenteNome);
			Integer oponenteAtaque = oponente.getAtaque();
			System.out.println("Ataque do Oponente: " + oponenteAtaque);

			Integer oponentePoder = oponente.getPoder() + new Random().nextInt(100);
			System.out.println("Poder do Oponente: " + oponentePoder);

			Integer oponenteDefesa = oponente.getDefesa();
			System.out.println("Defesa do Oponente: " + oponenteDefesa);

			Integer oponenteVida = oponente.getVida();
			System.out.println("Vida do Oponente: " + oponenteVida);
			System.out.println();

			for (int i = 1; i <= 10; i++) {
				System.out.println();
				System.out.println(i + "ª Turno!!!");
				System.out.println();

				System.out.println("Ataque do " + jogadorNome);
				Integer jogadorDano = (jogadorAtaque + jogadorPoder) - oponenteDefesa;
				oponenteVida -= jogadorDano;
				System.out.println("Dano de ataque: " + jogadorDano);
				System.out.println("Vida do oponente: " + oponenteVida);
				System.out.println();

				System.out.println("Ataque do " + oponenteNome);
				Integer oponenteDano = (oponenteAtaque + oponentePoder) - jogadorDefesa;
				jogadorVida -= oponenteDano;
				System.out.println("Dano de ataque: " + oponenteDano);
				System.out.println("Sobrou de vida: " + jogadorVida);
				System.out.println();

			}

			if (jogadorVida == oponenteVida) {
				System.out.println("batalha terminou em empate!");
			}

			if (jogadorVida > oponenteVida) {
				vencedor = jogadorNome + " venceu!";
				System.out.println(jogadorNome + " venceu!");
			} else {
				vencedor = oponenteNome + " venceu!";
				System.out.println(oponenteNome + " venceu!");
			}

			return vencedor;
		} catch (NullPointerException e) {
			throw new NegocioException(jogador.getNickname() + " ainda não tem um herói selecionado!");
		}
	}

	public String batalhar(Integer id_jogador, Integer id_inimigo) throws NegocioException {

		return duelar(id_jogador, id_inimigo);
	}

	public String duelar(Integer id_jogador, Integer id_oponente) throws NegocioException {
		// GOTO
		return null;

	}
}
