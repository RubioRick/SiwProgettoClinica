package it.uniroma3.db.dao.jpa;

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
	public void save(Paziente p) {
		this.em.persist(p);

	}

	@Override
	public void remove(Paziente p) {
		this.em.remove(p);

	}

	@Override
	public void update(Paziente p) {
		Query query = this.em.createQuery("UPDATE Paziente SET nome = ?1, cognome = ?2, dataNascita = ?3, email = ?4,  WHERE codicefiscale = ?5");
		query.setParameter(1,p.getNome());
		query.setParameter(2,p.getCognome());
		query.setParameter(3,p.getDataDiNascita());
		query.setParameter(4,p.getEmail());
		query.setParameter(5,p.getCodiceFiscale());
		
	

	}

	@Override
	public Paziente findByPrimaryKey(String cf) {
		Paziente p = this.em.find(Paziente.class, cf);
		return p;
	}

}
