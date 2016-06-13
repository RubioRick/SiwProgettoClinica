package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.db.dao.jpa.MedicoDaoJpa;
import it.uniroma3.db.models.Medico;

@ManagedBean
public class MedicoController {

	@ManagedProperty(value="#{param.id}")
	private long id;
	private String password;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private Medico medico;
	private List<Medico> medici;
	
	@EJB
	private MedicoDaoJpa medicoFacade;
	
	public String creaMedico(){
		this.medico = new Medico(id, password, nome, cognome, dataDiNascita);
		medicoFacade.save(medico);
		return "medico";
	}
	
	public String trovaMedico(){
		this.medico = medicoFacade.findByPrimaryKey(id);
		return "medico";
	}
	
	public String trovaMedico(long id){
		this.medico = medicoFacade.findByPrimaryKey(id);
		return "medico";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedici() {
		return medici;
	}

	public void setMedici(List<Medico> medici) {
		this.medici = medici;
	}

	public MedicoDaoJpa getMedicoFacade() {
		return medicoFacade;
	}

	public void setMedicoFacade(MedicoDaoJpa medicoFacade) {
		this.medicoFacade = medicoFacade;
	}
	
}
