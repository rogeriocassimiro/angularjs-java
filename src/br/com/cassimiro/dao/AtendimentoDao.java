package br.com.cassimiro.dao;

import java.util.List;

import br.com.cassimiro.domain.Atendimento;

public interface AtendimentoDao {

	Atendimento salvarOuAtualizar(Atendimento atendimento);
	
	void remover(Atendimento atendimento);
	
	List<Atendimento> listar();
	
	Atendimento findById(Long id);
}
