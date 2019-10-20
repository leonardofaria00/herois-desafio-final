package com.stefanini.desafio.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.desafio.entities.Jogador;
import com.stefanini.desafio.rest.exceptions.NegocioException;
import com.stefanini.desafio.service.JogadorService;

@Path("/autenticar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginAPI {

	@Inject
	JogadorService service;

	@POST
	public Response login(Jogador jogador) throws NegocioException {
		return Response.ok(service.getJogadorByID(jogador)).build();

	}
}
