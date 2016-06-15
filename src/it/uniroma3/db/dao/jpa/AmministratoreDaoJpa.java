package it.uniroma3.db.dao.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.db.dao.AmministratoreDao;
import it.uniroma3.db.models.Amministratore;
import it.uniroma3.db.models.Esame;
import it.uniroma3.db.models.Medico;

@Stateless(name = "FacadeAdm")
public class AmministratoreDaoJpa implements AmministratoreDao {
	
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public Amministratore save(Long id , String nome , String password) {
		Amministratore a = new Amministratore();
		this.em.persist(a);
		return a;
	}

	@Override
	public void remove(Amministratore a) {
		this.em.remove(a);
	}

	@Override
	public void update(Amministratore a) {
		this.em.merge(a);
	}

	@Override
	public Amministratore findByPrimaryKey(Long id) {
		Amministratore a = this.em.find(Amministratore.class, id);
		return a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Esame> trovaEsamiMedico(String nome, String cognome) {
	Query query = em.createQuery("SELECT e FROM ( Esame JOIN Medico ON (id = medico) ) AS e WHERE e.medico.nome = " + nome + "AND e.medico.cognome =" + cognome);
	 return (List<Esame>)query.getResultList();
	}

	

}