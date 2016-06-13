package it.uniroma3.db.models;


import java.util.ArrayList;
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
public class TipologiaEsame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "tipologiaEsame")
	private List<Esame> esamiAssociati;
	
	@ManyToMany(mappedBy = "tipologiaEsami")
	@JoinColumn(name = "requisito")
	private List<Requisito> requisiti;
	
	public TipologiaEsame(){
		this.esamiAssociati = new ArrayList<Esame>();
	}
	
	public TipologiaEsame(long id, String nome){
		this.id = id;
		this.nome = nome;
		this.esamiAssociati = new ArrayList<Esame>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Esame> getEsamiAssociati() {
		return esamiAssociati;
	}

	public void setEsamiAssociati(List<Esame> esamiAssociati) {
		this.esamiAssociati = esamiAssociati;
	}
	
	
	
	
	
	

}
