package br.com.cassimiro.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.cassimiro.dao.AtendimentoDao;
import br.com.cassimiro.domain.Atendimento;

@SuppressWarnings("unchecked")
public class AtendimentoDaoImpl implements AtendimentoDao{

	@PersistenceContext(unitName = "AtendimentoPU")
	private EntityManager em;

	@Override
	public Atendimento salvarOuAtualizar(Atendimento atendimento) {
		
		if(atendimento.getProtocolo() != null) {
			atendimento = em.merge(atendimento);
		}
		
		em.persist(atendimento);
		
		return atendimento;
	}

	@Override
	public void remover(Atendimento atendimento) {
		
		atendimento = em.merge(atendimento);
		
		em.remove(atendimento);
	}

	@Override
	public List<Atendimento> listar() {
		
		Query query = em.createQuery("from Atendimento");
		
		return query.getResultList();
	}

	@Override
	public Atendimento findByProtocolo(Integer protocolo) {
		
		return em.find(Atendimento.class, protocolo);
	}
	
	
	
}
