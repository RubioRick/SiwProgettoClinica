package it.uniroma3.db.dao.jpa;


import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.db.dao.EsameDao;
import it.uniroma3.db.models.Esame;
import it.uniroma3.db.models.Medico;
import it.uniroma3.db.models.Paziente;
import it.uniroma3.db.models.TipologiaEsame;

@Stateless(name = "esameFacade")
public class EsameDaoJpa implements EsameDao {
	
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public Esame save( TipologiaEsame tipologiaEsame, Medico medico,
			Paziente paziente, Date data) {
		Esame e = new Esame();
		e.setData(data);e.setMedicoResponsabile(medico);e.setPaziente(paziente);e.setTipologiaEsame(tipologiaEsame);
		this.em.persist(e);
		return e;
	}

	@Override
	public void remove(Esame e) {
		this.em.remove(e);
		
	}

	@Override
	public void update(Esame e) {
		this.em.merge(e);
		
	}

	@Override
	public Esame findByPromaryKey(Long id) {
		Esame e = this.em.find(Esame.class, id);
		return e;
	}

	@Override
	public List<Esame> findAll() {
		CriteriaQuery<Esame> esami = em.getCriteriaBuilder().createQuery(Esame.class);
        esami.select(esami.from(Esame.class));
        List<Esame> list = em.createQuery(esami).getResultList();
		return list;
	}

}
