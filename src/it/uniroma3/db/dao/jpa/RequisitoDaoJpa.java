package it.uniroma3.db.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.db.dao.RequisitoDao;
import it.uniroma3.db.models.Requisito;

@Stateless(name = "FacadeReq")
public class RequisitoDaoJpa implements RequisitoDao {
	
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public void save(Requisito r) {
	this.em.persist(r);
		
	}

	@Override
	public void remove(Requisito r) {
		this.em.remove(r);
		
	}

	@Override
	public void update(Requisito r) {
		Query query = this.em.createQuery("UPDATE Requisito SET descrizione = ?1, WHERE nome = ?2");
		query.setParameter(1,r.getDescrizione());
		query.setParameter(2,r.getNome());
		
	
		
	}

	@Override
	public Requisito findByPrimaryKey(String nome) {
		Requisito r = this.em.find(Requisito.class, nome);
		return r;
	}

}