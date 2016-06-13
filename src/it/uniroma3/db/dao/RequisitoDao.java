package it.uniroma3.db.dao;

import it.uniroma3.db.models.Requisito;

public interface RequisitoDao {
	public Requisito save(String nome , String descrizione );
	public void remove(Requisito r);
	public void update(Requisito r);
	public Requisito findByPrimaryKey(String nome);

}