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
		Query query = this.em.createQuery("UPDATE Medico SET password = ?1, nome = ?2, cognome = ?3, dataNascita = ?4,  WHERE id = ?5");
                query.setParameter(1,m.getPassword());
                query.setParameter(2,m.getNome());
		query.setParameter(3,m.getCognome());
		query.setParameter(4,m.getDataDiNascita());
		query.setParameter(5,m.getId());
	}

	@Override
	public Medico findByPrimaryKey(long id) {
		Medico m = this.em.find(Medico.class, id);
		return m;
	}

}
