package it.uniroma3.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import it.uniroma3.db.dao.AmministratoreDao;
import it.uniroma3.db.dao.MedicoDao;
import it.uniroma3.db.dao.PazienteDao;
import it.uniroma3.db.models.Amministratore;
import it.uniroma3.db.models.Medico;
import it.uniroma3.db.models.Paziente;
import it.uniroma3.db.models.PortaleClinica;

@ManagedBean
@SessionScoped
public class LoginController {

	private String codiceFiscale;
	private String password;
	private Paziente paziente;
	private Amministratore amministratore;
	private Medico medico;

	@EJB
	private PazienteDao pazienteFacade;

	@EJB
	private MedicoDao medicoFacade;
	
	@EJB
	private AmministratoreDao ammistratoreFacade;

	public String loginPaziente(){
		Long id;
		try{
			id = Long.parseLong(codiceFiscale);
			if(id < 100){
				amministratore = ammistratoreFacade.findByPrimaryKey(id);
				if(!amministratore.getPassword().equals(PortaleClinica.toSHA1(password)))
					amministratore = null;
			}
			else{
				medico = medicoFacade.findByPrimaryKey(id);
				if(!medico.getPassword().equals(PortaleClinica.toSHA1(password)))
					medico = null;
			}	
		} catch(Exception e){
			paziente = pazienteFacade.findByPrimaryKey(codiceFiscale);
			if(!paziente.getPassword().equals(PortaleClinica.toSHA1(password)))
				paziente = null;
		}
		if(paziente == null && amministratore == null && medico == null){
			return "faces/Welcome.jsp?error='Impossibile effettuare il login'";
		}
		return "faces/Welcome.jsp";
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PazienteDao getPazienteFacade() {
		return pazienteFacade;
	}

	public MedicoDao getMedicoFacade() {
		return medicoFacade;
	}
}
