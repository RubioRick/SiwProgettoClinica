package it.uniroma3.db.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.db.dao.AmministrazioneDao;
import it.uniroma3.db.models.Amministrazione;

@Stateless(name = "FacadeAdm")
public class AmministrazioneDaoJpa implements AmministrazioneDao {
	
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public void save(Amministrazione a) {
	this.em.persist(a);
		
	}
	
	
	

	@Override
	public void remove(Amministrazione a) {
		this.em.remove(a);
		
	}

	@Override
	public void update(Amministrazione a) {
		Query query = this.em.createQuery("UPDATE Amministrazione SET nome = ?1, password = ?2 WHERE id = ?3");
		query.setParameter(1,r.getNome());
		query.setParameter(2,r.getPassword());
		query.setParameter(3,r.getId());
	
		
	}

	@Override
	public Amministrazione findByPrimaryKey(String id) {
		Amministrazione a = this.em.find(Amministrazione.class, id);
		return a;
	}

}