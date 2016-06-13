package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.db.dao.jpa.RisultatiEsameDaoJpa;
import it.uniroma3.db.models.RisultatoEsame;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class RisultatiEsameController {

	@ManagedProperty(value= "#{param.id}")
	private Long id;
	private Long idEsame;
	private String descrizione;
	private String risultato;
	private RisultatoEsame risEsame;
	private List<RisultatoEsame> risultati;
	
	@EJB
	private RisultatiEsameDaoJpa risultatoEsameFacade;
	
	public String creaRisultato(){
		this.risEsame = risultatoEsameFacade.save(idEsame, descrizione, risultato);
		return "risultato";
	}
	
	public String trovaRisultato(){
		this.risEsame = risultatoEsameFacade.findByPrimaryKey(id);
		return "risultato";
	}
	
	public String trovaRisultato(Long id){
		this.risEsame = risultatoEsameFacade.findByPrimaryKey(id);
		return "risultato";
	}
	
	public String trovaRisultati(){
		this.risultati = risultatoEsameFacade.risultatiDi(idEsame);
		return "risultati";
	}
	
	
	
	public Long getId() {
		return idEsame;
	}
	public void setId(Long id) {
		this.idEsame = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getRisultato() {
		return risultato;
	}
	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}

	public Long getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(Long idEsame) {
		this.idEsame = idEsame;
	}

	public RisultatoEsame getRisEsame() {
		return risEsame;
	}

	public void setRisEsame(RisultatoEsame risEsame) {
		this.risEsame = risEsame;
	}

	public RisultatiEsameDaoJpa getRisultatoEsameFacade() {
		return risultatoEsameFacade;
	}

	public void setRisultatoEsameFacade(RisultatiEsameDaoJpa risultatoEsameFacade) {
		this.risultatoEsameFacade = risultatoEsameFacade;
	}

	public List<RisultatoEsame> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<RisultatoEsame> risultati) {
		this.risultati = risultati;
	}
	
}
