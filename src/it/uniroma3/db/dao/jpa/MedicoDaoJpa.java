package it.uniroma3.db.dao.jpa;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.db.dao.MedicoDao;
import it.uniroma3.db.models.Medico;

@Stateless(name = "medFacade")
public class MedicoDaoJpa implements MedicoDao {
	@PersistenceContext(unitName = "clinica")
    private EntityManager em;

	@Override
	public Medico save(long id, String password, String nome, String cognome,
			Date dataDiNascita) {
		Medico m = new Medico(id, password, nome, cognome, dataDiNascita);
		this.em.persist(m);
		return m;
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
