package it.uniroma3.db.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Requisito {



	@Id
	private String nome;

	@Column(nullable = false)
	private long descrizione;

	@ManyToMany
	@JoinColumn (name ="tipologiaEsame")
	private List<TipologiaEsame> tipologiaEsami;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(long descrizione) {
		this.descrizione = descrizione;
	}
	
	
	
	
}
