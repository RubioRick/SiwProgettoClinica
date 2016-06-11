package it.uniroma3.db.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.db.dao.AmministratoreDao;
import it.uniroma3.db.models.Amministratore;

@Stateless(name = "FacadeAdm")
public class AmministratoreDaoJpa implements AmministratoreDao {
	
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public void save(Amministratore a) {
	this.em.persist(a);
		
	}
	
	
	

	@Override
	public void remove(Amministratore a) {
		this.em.remove(a);
		
	}

	@Override
	public void update(Amministratore a) {
		Query query = this.em.createQuery("UPDATE Amministratore SET nome = ?1, password = ?2 WHERE id = ?3");
		query.setParameter(1,a.getNome());
		query.setParameter(2,a.getPassword());
		query.setParameter(3,a.getId());
	
		
	}

	@Override
	public Amministratore findByPrimaryKey(String id) {
		Amministratore a = this.em.find(Amministratore.class, id);
		return a;
	}

}