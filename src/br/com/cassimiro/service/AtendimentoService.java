package br.com.cassimiro.service;

import java.util.List;

import br.com.cassimiro.domain.Atendimento;

public interface AtendimentoService {

	void salvarOuAtualizar(Atendimento atendimento);

	void remover(Long id);
	
	List<Atendimento> listar();
}
