package it.uniroma3.db.dao;

import java.util.List;

import it.uniroma3.db.models.Amministratore;
import it.uniroma3.db.models.Esame;
import it.uniroma3.db.models.Medico;



public interface AmministratoreDao {
	public Amministratore save(Long id , String nome , String password);
	public void remove(Amministratore a);
	public void update(Amministratore a);
	public Amministratore findByPrimaryKey(Long id);
	public List<Esame> trovaEsamiMedico(String nome , String cognome);

}