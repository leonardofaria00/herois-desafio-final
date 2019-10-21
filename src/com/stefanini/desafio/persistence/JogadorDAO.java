package com.stefanini.desafio.persistence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import com.stefanini.desafio.entities.Jogador;
import com.stefanini.desafio.rest.exceptions.NegocioException;

@Transactional
public class JogadorDAO extends GenericDAO<Integer, Jogador> {

	@SuppressWarnings("unchecked")
	public List<Jogador> getJogadores() {
		return getEntityManager().createNamedQuery("Jogador.findAll").getResultList();
	}

	public Jogador getJogadorByID(Integer id) throws NegocioException {// Inspecionado
		try {
			return (Jogador) getEntityManager().createNamedQuery("Jogador.findByID").setParameter("id", id)
					.getSingleResult();
		} catch (NoResultException e) {
			throw new NegocioException("Nenhum jogador encontrado!");
		}
	}

	public Jogador getLogin(String login, String senha) throws NegocioException {// Inspecionado
		return (Jogador) getEntityManager().createNamedQuery("Jogador.findByLogin").setParameter("nickname", login)
				.setParameter("senha", senha).getSingleResult();

	}

	public Integer excluir(Integer id) {
		return getEntityManager().createNamedQuery("Jogador.removeByID").setParameter("id", id).executeUpdate();
	}

}
