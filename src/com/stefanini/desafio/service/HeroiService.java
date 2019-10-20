package com.stefanini.desafio.service;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.desafio.dto.HeroiDto;
import com.stefanini.desafio.parsers.HeroiParser;
import com.stefanini.desafio.persistence.HeroiDAO;

public class HeroiService {

	@Inject
	HeroiParser parser;

	@Inject
	HeroiDAO heroiDao;

	public List<HeroiDto> listar() {
		return parser.toDTO(heroiDao.list());
	}

}
