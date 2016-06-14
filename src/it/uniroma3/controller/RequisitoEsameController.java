package it.uniroma3.controller;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.db.dao.jpa.RequisitoDaoJpa;
import it.uniroma3.db.models.Requisito;



@ManagedBean
public class RequisitoEsameController {
	
	@ManagedProperty(value="#{param.id}")
	private String nome;
	private String descrizione;
	private Requisito requisito;
	private List<Requisito> requisiti;
	
	@EJB
	private RequisitoDaoJpa requisitoFacade;
	
	public String createRequisito() {
		this.requisito = requisitoFacade.save(nome, descrizione);
		return "requisito"; 
	}
	
	

	public String findRequisito() {
		this.requisito = requisitoFacade.findByPrimaryKey(nome);
		return "requisito";
	}
	
	public String findRequisito(String nome) {
		this.requisito = requisitoFacade.findByPrimaryKey(nome);
		return "requisito";
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



	public Requisito getRequisito() {
		return requisito;
	}



	public void setRequisito(Requisito requisito) {
		this.requisito = requisito;
	}



	public List<Requisito> getRequisiti() {
		return requisiti;
	}



	public void setRequisiti(List<Requisito> requisiti) {
		this.requisiti = requisiti;
	}




	


}