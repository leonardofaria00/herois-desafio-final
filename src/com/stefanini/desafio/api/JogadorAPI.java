package com.stefanini.desafio.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.desafio.entities.Heroi;
import com.stefanini.desafio.entities.Jogador;
import com.stefanini.desafio.parsers.JogadorParser;
import com.stefanini.desafio.persistence.HeroiDAO;
import com.stefanini.desafio.persistence.JogadorDAO;
import com.stefanini.desafio.rest.exceptions.NegocioException;

@Path("/jogador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorAPI {

	@Inject
	private JogadorDAO jDAO;

	@Inject
	private HeroiDAO hDAO;

	@GET
	public Response consultar() throws NegocioException {
		if (jDAO.getJogadores().isEmpty()) {
			System.out.println("Nao existe jogador cadastrado!");
			throw new NegocioException("Nao existe jogador cadastrado!");
		}

		return Response.ok(new JogadorParser().toDTO(jDAO.getJogadores())).build();
	}

	@GET
	@Path("/{id}")
	public Response consultar(@PathParam("id") Integer id) throws NegocioException {
		return Response.ok(jDAO.getJogadorByID(id)).build();
	}

	@PUT
	public Response alterar(Jogador j) throws NegocioException {
		Jogador jogarorPersistida = jDAO.getJogadorByID(j.getId());
		jogarorPersistida.setId(j.getId());
		jogarorPersistida.setNickname(j.getNickname());
		jogarorPersistida.setSenha(j.getSenha());
		return Response.ok(new JogadorParser().toDTO(jDAO.update(jogarorPersistida))).build();
	}

	@POST
	public Response cadastrar(Jogador p) {
		// GOTO
//		if (p.getCpf() != null) {
//			System.out.println("CPF ja cadastrado");
//			throw new NegocioException("CPF ja cadastrado!");
//		}
		System.out.println("Salvando: " + p.getNickname());
		jDAO.cadastrar(p);
		return Response.ok().build();
	}

	@POST
	@Path("/multi")
	public Response cadastrar(List<Jogador> list) {
		list.forEach(p -> {
			jDAO.cadastrar(p);
		});

		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response excluir(@PathParam("id") Integer id) {
		return Response.ok(jDAO.excluir(id)).build();
	}

	@DELETE
	public Response excluir2(@QueryParam("id") Integer id) {
		return Response.ok(jDAO.excluir(id)).build();
	}

	@GET
	@Path("/vincular/{id_jogador}/{id_heroi}")
	public Response cadastrarJogadoEHeroi(@PathParam("id_jogador") Integer id_jogador,
			@PathParam("id_heroi") Integer id_heroi) throws NegocioException {

		Jogador jogador = jDAO.getJogadorByID(id_jogador);
		Heroi heroi = hDAO.getHeroiByID(id_heroi);

		if (jogador.getId() == null || heroi.getId() == null) {
			throw new NegocioException("Informe um jogador e um Heroi válido");
		}

		if (jogador.getHeroi() != null && jogador.getHeroi().getId() != null) {
			throw new NegocioException("Jogador " + jogador.getNickname() + " já tem um Herói cadastrado");
		}
		jogador.setHeroi(heroi);
		jDAO.update(jogador);
		System.out.println("Jogador: " + jogador);
		return Response.ok(new JogadorParser().toDTO(jogador)).build();
	}

	@GET
	@Path("/batalhar")
	public Response batalhar() {
		// GOTO
		return Response.ok().build();
	}
}
