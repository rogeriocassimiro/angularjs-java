package br.com.cassimiro.controller;

import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.cassimiro.domain.Atendimento;
import br.com.cassimiro.service.AtendimentoService;

@Path("/atendimento")
@Produces("application/json")
public class AtendimentoController {

	@Inject
	private AtendimentoService atendimentoService;
	
	@GET
	@Path("/")
	public List<Atendimento> listarTodos() {
		return this.atendimentoService.listar();
	}
	
	@POST
	@Path("/")
	public void salvar(Atendimento atendimento) {
		this.atendimentoService.salvarOuAtualizar(atendimento);
	}
	
	@DELETE
	@Path("/{protocolo}")
	public void remover(@PathParam("atendimento") Integer protocolo) {
		this.atendimentoService.remover(protocolo);
	}
}
