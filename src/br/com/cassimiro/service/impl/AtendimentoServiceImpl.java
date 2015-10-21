package br.com.cassimiro.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.cassimiro.dao.AtendimentoDao;
import br.com.cassimiro.domain.Atendimento;
import br.com.cassimiro.service.AtendimentoService;

public class AtendimentoServiceImpl implements AtendimentoService{

	@Inject
	private AtendimentoDao atendimentoDao;

	@Transactional
	@Override
	public void salvarOuAtualizar(Atendimento atendimento) {
		
		this.atendimentoDao.salvarOuAtualizar(atendimento);
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		this.atendimentoDao.remover(this.atendimentoDao.findById(id));
	}
	
	@Transactional
	@Override
	public List<Atendimento> listar() {
		return this.atendimentoDao.listar();
	}
	
}
