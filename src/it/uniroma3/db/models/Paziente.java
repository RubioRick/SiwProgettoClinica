package it.uniroma3.db.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Paziente {
	
	@Id
	private String codiceFiscale;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;
	
	@Column(unique=true)
	private String email;
	
	@OneToMany(mappedBy = "paziente")
	private List<Esame> esami;
	
	public Paziente(){
		this.esami = new ArrayList<Esame>();
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Paziente"); 
		sb.append("{codiceFiscale=").append(codiceFiscale); 
		sb.append(", nome='").append(nome);
		sb.append(", cognome='").append(cognome);
		sb.append(", dataDiNascita=").append(dataDiNascita); 
		sb.append(", email='").append(email); 
		sb.append("}\n");
		return sb.toString();
	}
	public List<Esame> getEsami() {
		return esami;
	}
	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

}
