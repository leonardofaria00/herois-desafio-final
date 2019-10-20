package com.stefanini.desafio.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.desafio.service.HeroiService;

@Path("/heroi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HeroiApi {

	@Inject
	private HeroiService heroiService;

	@GET
	public Response listar() {
		return Response.ok(heroiService.listar()).build();
	}
}
