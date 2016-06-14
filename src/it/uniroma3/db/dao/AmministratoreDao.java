package it.uniroma3.db.dao;

import it.uniroma3.db.models.Amministratore;



public interface AmministratoreDao {
	public Amministratore save(Long id , String nome , String password);
	public void remove(Amministratore a);
	public void update(Amministratore a);
	public Amministratore findByPrimaryKey(Long id);

}