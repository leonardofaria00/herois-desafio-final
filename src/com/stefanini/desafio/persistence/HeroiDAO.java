package com.stefanini.desafio.persistence;

import javax.persistence.NoResultException;

import com.stefanini.desafio.entities.Heroi;
import com.stefanini.desafio.rest.exceptions.NegocioException;

public class HeroiDAO extends GenericDAO<Integer, Heroi> {
	
	
	
	public Heroi getHeroiByID(Integer id) throws NegocioException {
		try {
			return (Heroi) getEntityManager().
					createNamedQuery("Heroi.findByID").
					setParameter("id", id).
					getSingleResult();
		} catch (NoResultException e) {
			throw new NegocioException("Nenhum Heroi encontrado!");
		}
	}
}
