package it.uniroma3.db.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.db.dao.MedicoDao;
import it.uniroma3.db.models.Medico;

@Stateless(name = "medFacade")
public class MedicoDaoJpa implements MedicoDao {
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public void save(Medico m) {
		this.em.persist(m);
	}

	@Override
	public void remove(Medico m) {
		this.em.remove(m);
	}

	@Override
	public void update(Medico m) {
		this.em.merge(m);
	}

	@Override
	public Medico findByPrimaryKey(long id) {
		Medico m = this.em.find(Medico.class, id);
		return m;
	}

}
