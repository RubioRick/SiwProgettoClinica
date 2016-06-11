package it.uniroma3.db.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.db.dao.TipologiaEsameDao;
import it.uniroma3.db.models.TipologiaEsame;

@Stateless(name = "tipFacade")
public class TipologiaEsameDaoJpa implements TipologiaEsameDao {
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public void save(TipologiaEsame t) {
		this.em.persist(t);
	}

	@Override
	public void remove(TipologiaEsame t) {
		this.em.remove(t);
	}

	@Override
	public void update(TipologiaEsame t) {
		this.em.merge(t);
	}

	@Override
	public TipologiaEsame findByPrimaryKey(long id) {
		TipologiaEsame t = this.em.find(TipologiaEsame.class, id);
		return t;
	}

}
