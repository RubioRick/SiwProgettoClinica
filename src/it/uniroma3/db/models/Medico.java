package it.uniroma3.db.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@TableGenerator(name="tab1", initialValue=100, allocationSize=999)
public class Medico {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab1")
	private Long id;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;
	
	@OneToMany(mappedBy = "MedicoResponsabile")
	private List<Esame> esamiEffettuati;
	
	public Medico(){
		this.esamiEffettuati = new ArrayList<Esame>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Esame> getEsamiEffettuati() {
		return esamiEffettuati;
	}

	public void setEsamiEffettuati(List<Esame> esamiEffettuati) {
		this.esamiEffettuati = esamiEffettuati;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Paziente"); 
		sb.append("{id=").append(id); 
		sb.append(", nome='").append(nome);
		sb.append(", cognome='").append(cognome);
		sb.append(", dataDiNascita=").append(dataDiNascita); 
		sb.append("}\n");
		return sb.toString();
	}
	
	

}
