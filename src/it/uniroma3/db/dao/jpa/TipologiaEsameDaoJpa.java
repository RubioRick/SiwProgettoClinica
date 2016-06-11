package it.uniroma3.db.dao.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.db.dao.TipologiaEsameDao;
import it.uniroma3.db.models.TipologiaEsame;
import it.uniroma3.model.Product;


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
                query.setParameter(1,t.getNome());
		query.setParameter(2,t.getId());
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
