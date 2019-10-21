package com.stefanini.desafio.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.desafio.entities.Jogador;
import com.stefanini.desafio.rest.exceptions.NegocioException;
import com.stefanini.desafio.service.JogadorService;

@Path("/jogador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorAPI extends BaseAPI {

	@Inject
	JogadorService service;

	@GET
	public Response consultar() throws NegocioException {// Inspecionado
		return Response.ok(service.getJogadores()).build();
	}

	@POST
	public Response cadastrar(Jogador p) throws NegocioException {// Inspecionado
		System.out.println("Salvando jogador: " + p.getNickname());
		service.cadastrar(p);
		return Response.ok().build();
	}

	@GET
	@Path("/vincular/{id_jogador}/{id_heroi}")
	public Response vincularJogadoEHeroi(@PathParam("id_jogador") Integer id_jogador,
			@PathParam("id_heroi") Integer id_heroi) throws NegocioException {// Inspecionado

		return Response.ok(service.vincularJogadoEHeroi(id_jogador, id_heroi)).build();
	}
}
