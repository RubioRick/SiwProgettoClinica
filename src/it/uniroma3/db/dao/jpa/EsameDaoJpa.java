package it.uniroma3.db.dao.jpa;


import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Esame> getEsamiPerPaziente(Paziente p) {
		Query query = em.createQuery("SELECT e FROM Esame e WHERE e.paziente = " + p.getCodiceFiscale());
		return query.getResultList();
		
	}

	@Override
	public Esame save(TipologiaEsame tipologia, Long id, String codiceFiscale,
			Date data) {
		Esame e = new Esame();
		MedicoDaoJpa medicoFacade = new MedicoDaoJpa();
		Medico m = medicoFacade.findByPrimaryKey(id);
		PazienteDaoJpa pazienteFacade = new PazienteDaoJpa();
		Paziente p = pazienteFacade.findByPrimaryKey(codiceFiscale);
		e.setData(data); e.setTipologiaEsame(tipologia);e.setMedicoResponsabile(m); e.setPaziente(p);
		this.em.persist(e);
		return e;
	}



}
