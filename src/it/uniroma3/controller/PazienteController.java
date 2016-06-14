package it.uniroma3.controller;

import it.uniroma3.db.dao.jpa.PazienteDaoJpa;
import it.uniroma3.db.models.Paziente;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class PazienteController {

	@ManagedProperty(value="#{param.id}")
	private String codiceFiscale;
	private String nome;
	private String password;
	private String cognome;
	private String email;
	private Date dataNascita;
	private Paziente paziente;
	private List<Paziente> pazienti;
	
	@EJB
	private PazienteDaoJpa pazienteFacade;
	
	public String creaPaziente(){
		this.paziente = pazienteFacade.save(nome, cognome,password, codiceFiscale, email, dataNascita);
		return "paziente";
	}
	
	public String trovaPaziente(){
		this.paziente = pazienteFacade.findByPrimaryKey(codiceFiscale);
		return "paziente";
	}
	
	public String trovaPaziente(String cf){
		this.paziente = pazienteFacade.findByPrimaryKey(codiceFiscale);
		return "paziente";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public List<Paziente> getPazienti() {
		return pazienti;
	}

	public void setPazienti(List<Paziente> pazienti) {
		this.pazienti = pazienti;
	}

	public PazienteDaoJpa getPazienteFacade() {
		return pazienteFacade;
	}

	public void setPazienteFacade(PazienteDaoJpa pazienteFacade) {
		this.pazienteFacade = pazienteFacade;
	}
	
}