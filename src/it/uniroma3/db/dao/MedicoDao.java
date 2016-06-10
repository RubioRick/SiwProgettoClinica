package it.uniroma3.db.dao;

import it.uniroma3.db.models.Medico;

public interface MedicoDao {
	public void save(Medico m);
	public void remove(Medico m);
	public void update(Medico m);
	public Medico findByPrimaryKey(long id);
}
