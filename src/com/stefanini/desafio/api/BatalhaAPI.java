package com.stefanini.desafio.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.desafio.rest.exceptions.NegocioException;
import com.stefanini.desafio.service.BatalhaService;

@Path("/batalhar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BatalhaAPI extends BaseAPI{

	@Inject
	BatalhaService service;

	@GET
	@Path("/{id_jogador}") // Inspecionado
	public Response batalhar(@PathParam("id_jogador") Integer id_jogador) throws NegocioException {
		return Response.ok(service.batalhar(id_jogador)).build();
	}

	@GET
	@Path("/{id_jogador}/{id_inimigo}") // Inspecionado
	public Response batalhar(@PathParam("id_jogador") Integer id_jogador, @PathParam("id_inimigo") Integer id_inimigo) throws NegocioException {
		return Response.ok(service.batalhar(id_jogador, id_inimigo)).build();
	}
}
