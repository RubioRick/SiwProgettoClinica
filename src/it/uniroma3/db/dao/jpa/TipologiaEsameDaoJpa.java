package it.uniroma3.db.dao.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.db.dao.TipologiaEsameDao;
import it.uniroma3.db.models.TipologiaEsame;


@Stateless(name = "tipFacade")
public class TipologiaEsameDaoJpa implements TipologiaEsameDao {
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public TipologiaEsame save(long id, String nome) {
		TipologiaEsame t = new TipologiaEsame(id, nome);
		this.em.persist(t);
		return t;
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

	
	@Override
	public List<TipologiaEsame> findAll() {
		 CriteriaQuery<TipologiaEsame> cq = em.getCriteriaBuilder().createQuery(TipologiaEsame.class);
	        cq.select(cq.from(TipologiaEsame.class));
	        List<TipologiaEsame> tipologieEsame = em.createQuery(cq).getResultList();
			return tipologieEsame;
	}

}
