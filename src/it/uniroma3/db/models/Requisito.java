package it.uniroma3.db.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class Requisito {

	@ManyToMany
	@JoinColumn(name = "tipologiaEsame")
	private List<TipologiaEsame> tipologiaEsami;
	
	@Id
	private String nome;
	
	@Column(nullable = false)
	private String descrizione;

	public List<TipologiaEsame> getTipologiaEsami() {
		return tipologiaEsami;
	}

	public void setTipologiaEsami(List<TipologiaEsame> tipologiaEsami) {
		this.tipologiaEsami = tipologiaEsami;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
