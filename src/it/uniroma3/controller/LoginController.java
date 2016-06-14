package it.uniroma3.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.uniroma3.db.dao.jpa.PazienteDaoJpa;
import it.uniroma3.db.models.Paziente;
import it.uniroma3.db.models.PortaleClinica;

@ManagedBean
public class LoginController {
	
	private String codiceFiscale;
	private String password;
	private String nomeCliente;

	@EJB
	private PazienteDaoJpa pazienteFacade;
	
	public String loginPaziente(){
		Paziente p = pazienteFacade.findByPrimaryKey(codiceFiscale);
		if(p != null && p.getPassword().equals(PortaleClinica.toSHA1(password))){
			this.nomeCliente = p.getNome();
		}
		else
			return "faces/Welcome.jsp?error='Impossibile effettuare il login'";
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

	public String getNomeCliente() {
		return nomeCliente;
	}
}
