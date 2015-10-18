package br.com.cassimiro.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATENDIMENTO")
public class Atendimento implements Serializable{

	private static final long serialVersionUID = -5342725151990997575L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer protocolo;
	
	private String nomeCliente;
	
	private String detalhamento;

	public Integer getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Integer protocolo) {
		this.protocolo = protocolo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}
	
	
	
}
