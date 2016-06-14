package it.uniroma3.db.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import it.uniroma3.db.dao.AmministratoreDao;
import it.uniroma3.db.models.Amministratore;

@Stateless(name = "FacadeAdm")
public class AmministratoreDaoJpa implements AmministratoreDao {
	
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public Amministratore save(String id , String nome , String password) {
		Amministratore a = new Amministratore();
		this.em.persist(a);
		return a;
	}

	@Override
	public void remove(Amministratore a) {
		this.em.remove(a);
	}

	@Override
	public void update(Amministratore a) {
		this.em.merge(a);
	}

	@Override
	public Amministratore findByPrimaryKey(String id) {
		Amministratore a = this.em.find(Amministratore.class, id);
		return a;
	}

}