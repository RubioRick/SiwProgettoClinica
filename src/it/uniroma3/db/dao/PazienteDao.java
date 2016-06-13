package it.uniroma3.db.dao;

import java.util.Date;
import java.util.List;

import it.uniroma3.db.models.Paziente;

public interface PazienteDao {
	public Paziente save(String name, String Cognome,String password, String cf, String email, Date dataNascita);
	public void remove(Paziente p);
	public void update(Paziente p);
	public Paziente findByPrimaryKey(String cf);
	public List<Paziente> findAll();
}
