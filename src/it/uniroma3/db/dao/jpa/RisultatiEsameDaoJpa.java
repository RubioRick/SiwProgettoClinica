package it.uniroma3.db.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.db.dao.RisultatiEsameDao;
import it.uniroma3.db.models.RisultatoEsame;

@Stateless(name = "risFacade")
public class RisultatiEsameDaoJpa implements RisultatiEsameDao {
	
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public void save(RisultatoEsame r) {
		this.em.persist(r);
	}

	@Override
	public void remove(RisultatoEsame r) {
		this.em.remove(r);
	}

	@Override
	public void update(RisultatoEsame r) {
		this.em.merge(r);
	}

	@Override
	public RisultatoEsame findByPrimaryKey(String id) {
		RisultatoEsame r = this.em.find(RisultatoEsame.class, id);
		return r;
	}

}
