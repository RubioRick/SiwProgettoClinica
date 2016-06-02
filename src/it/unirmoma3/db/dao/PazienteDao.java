package it.unirmoma3.db.dao;

import it.uniroma3.db.models.Paziente;

public interface PazienteDao {

	public void save(Paziente p);



	public void remove(Paziente p);



	public void update(Paziente p);

	public void findByPrimaryKey(String cf);




}
