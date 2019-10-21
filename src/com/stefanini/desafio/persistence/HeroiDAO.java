package com.stefanini.desafio.persistence;

import java.util.List;

import javax.persistence.NoResultException;

import com.stefanini.desafio.entities.Heroi;
import com.stefanini.desafio.rest.exceptions.NegocioException;

public class HeroiDAO extends GenericDAO<Integer, Heroi> {
	
	@SuppressWarnings("unchecked")
	public List<Heroi> getHerois() {// Inspecionado
		return getEntityManager().createNamedQuery("Heroi.getAll").getResultList();
	}

	public Heroi getHeroiByID(Integer id) throws NegocioException {// Inspecionado
		try {
			return (Heroi) getEntityManager().createNamedQuery("Heroi.findByID").setParameter("id", id)
					.getSingleResult();
		} catch (NoResultException e) {
			throw new NegocioException("Nenhum Heroi encontrado!");
		}
	}
}
