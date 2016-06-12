package it.uniroma3.db.dao.jpa;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.db.dao.PazienteDao;
import it.uniroma3.db.models.Paziente;

@Stateless(name = "pazFacade")
public class PazienteDaoJpa implements PazienteDao {
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public Paziente save(String nome, String Cognome, String cf, String email, Date dataNascita) {
		Paziente p = new Paziente();
		p.setCodiceFiscale(cf);p.setCognome(Cognome);p.setDataDiNascita(dataNascita);p.setEmail(email);p.setNome(nome);
		this.em.persist(p);
		return p;
	}

	@Override
	public void remove(Paziente p) {
		this.em.remove(p);
	}

	@Override
	public void update(Paziente p) {
		this.em.merge(p);
	}

	@Override
	public Paziente findByPrimaryKey(String cf) {
		Paziente p = this.em.find(Paziente.class, cf);
		return p;
	}

}
