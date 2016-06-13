package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.db.dao.jpa.TipologiaEsameDaoJpa;
import it.uniroma3.db.models.TipologiaEsame;

@ManagedBean
public class TipologiaEsameController {

	@ManagedProperty(value="#{param.id}")
	private long id;
	private String nome;
	private TipologiaEsame tipologiaEsame;
	private List<TipologiaEsame> tipologieEsame;
	
	@EJB
	private TipologiaEsameDaoJpa tipologiaEsameFacade;
	
	public String creaTipologiaEsame(){
		tipologiaEsameFacade.save(id, nome);
		return "tipologiaEsame";
	}
	
	public String trovaTipologiaEsame(){
		this.tipologiaEsame = tipologiaEsameFacade.findByPrimaryKey(id);
		return "tipologiaEsame";
	}
	
	public String trovaTipologiaEsame(long id){
		this.tipologiaEsame = tipologiaEsameFacade.findByPrimaryKey(id);
		return "tipologiaEsame";
	}

	public List<TipologiaEsame> trovaTutteLeTipologieEsame(){
		this.tipologieEsame = tipologiaEsameFacade.findAll();
		return this.tipologieEsame;
	}
	
	public Long getId() {
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

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public List<TipologiaEsame> getTipologieEsame() {
		return tipologieEsame;
	}

	public void setTipologieEsame(List<TipologiaEsame> tipologieEsame) {
		this.tipologieEsame = tipologieEsame;
	}

	public TipologiaEsameDaoJpa getTipologiaEsameFacade() {
		return tipologiaEsameFacade;
	}

	public void setTipologiaEsameFacade(TipologiaEsameDaoJpa TipologiaEsameFacade) {
		this.tipologiaEsameFacade = TipologiaEsameFacade;
	}
	
}
