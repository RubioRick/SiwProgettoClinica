package it.uniroma3.controller;
import java.util.Date;
import java.util.List;

import it.uniroma3.db.dao.jpa.EsameDaoJpa;
import it.uniroma3.db.models.Esame;
import it.uniroma3.db.models.Medico;
import it.uniroma3.db.models.Paziente;
import it.uniroma3.db.models.TipologiaEsame;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class EsameController {

	private Long id;
	private Medico medico;
	private Paziente paziente;
	private TipologiaEsame tipologia;
	private Date data;
	private Esame esame;
	private List<Esame> esami;

	@EJB
	private EsameDaoJpa esameFacade;
	
	public String CreaEsame(){
		this.esame = esameFacade.save( tipologia, medico, paziente, data);
		return "esame";
	}
	
	public String listaEsami(){
		this.esami = esameFacade.findAll();
		return "esami";
	}
	
	public String trovaEsame(Long id){
		this.esame = esameFacade.findByPromaryKey(id);
		return "esame";
	}
	
	public String trovaEsame(){
		this.esame = esameFacade.findByPromaryKey(id);
		return "esame";
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public TipologiaEsame getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaEsame tipologia) {
		this.tipologia = tipologia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	public EsameDaoJpa getEsameFacade() {
		return esameFacade;
	}

	public void setEsameFacade(EsameDaoJpa esameFacade) {
		this.esameFacade = esameFacade;
	}
	
	

}
