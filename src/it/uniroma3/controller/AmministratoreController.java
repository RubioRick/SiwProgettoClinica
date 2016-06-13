package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.db.dao.jpa.AmministratoreDaoJpa;
import it.uniroma3.db.models.Amministratore;



@ManagedBean
public class AmministratoreController {
	
	@ManagedProperty(value="#{param.id}")
	private String id;
	private String nome;
	private String password;
	private Amministratore amministratore;
	private List<Amministratore> amministratori;
	
	@EJB
	private AmministratoreDaoJpa amministratoreFacade;
	
	public String createAmministratore() {
		this.amministratore = amministratoreFacade.save(id, nome, password);
		return "amministratore"; 
	}
	
	

	public String findAmministratore() {
		this.amministratore = amministratoreFacade.findByPrimaryKey(id);
		return "amministratore";
	}
	
	public String findAmministratore(String id) {
		this.amministratore = amministratoreFacade.findByPrimaryKey(id);
		return "amministartore";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Amministratore getAmministratore() {
		return amministratore;
	}



	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}



	public List<Amministratore> getAmministratori() {
		return amministratori;
	}



	public void setAmministratori(List<Amministratore> amministratori) {
		this.amministratori = amministratori;
	}



	public AmministratoreDaoJpa getAmministratoreFacade() {
		return amministratoreFacade;
	}



	public void setAmministratoreFacade(AmministratoreDaoJpa amministratoreFacade) {
		this.amministratoreFacade = amministratoreFacade;
	}


}