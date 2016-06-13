package it.uniroma3.db.dao;

import java.util.Date;

import it.uniroma3.db.models.Medico;

public interface MedicoDao {
	public Medico save(long id, String password, String nome, String cognome,
			Date dataDiNascita);
	public void remove(Medico m);
	public void update(Medico m);
	public Medico findByPrimaryKey(long id);
}
