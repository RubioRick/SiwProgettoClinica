package it.uniroma3.db.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		Query query = this.em.createQuery("UPDATE TipologiaEsame SET nome = ?1,  WHERE id = ?2");
                query.setParameter(1,m.getNome());
		query.setParameter(2,m.getId());
	}

	@Override
	public TipologiaEsame findByPrimaryKey(long id) {
		TipologiaEsame t = this.em.find(TipologiaEsame.class, id);
		return t;
	}

}
