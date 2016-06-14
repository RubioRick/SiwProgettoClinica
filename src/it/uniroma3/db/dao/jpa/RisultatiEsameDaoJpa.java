package it.uniroma3.db.dao.jpa;

import java.util.List;

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
	public RisultatoEsame save(Long id,String descrizione, String risultato) {
		RisultatoEsame r = new RisultatoEsame();
		r.setIdEsame(id);r.setDescrizione(descrizione);r.setRisultato(risultato);
		this.em.persist(r);
		return r;
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
	public RisultatoEsame findByPrimaryKey(Long id) {
		RisultatoEsame r = this.em.find(RisultatoEsame.class, id);
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RisultatoEsame> risultatiDi(Long idEsame) {
		Query query = em.createQuery("SELECT e FROM Esami e WHERE idEsame = " + idEsame);
		return query.getResultList();
		
	}

}
