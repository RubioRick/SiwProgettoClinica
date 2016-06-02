package it.uniroma3.db.models;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "portaleClinica")
public class PortaleClinica {
	
	@PersistenceContext(unitName="clinic")
	private EntityManager em;
	
	
	

}
