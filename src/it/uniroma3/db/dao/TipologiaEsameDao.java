package it.uniroma3.db.dao;

import java.util.List;

import it.uniroma3.db.models.TipologiaEsame;

public interface TipologiaEsameDao {
	public TipologiaEsame save(String nome, String descrizione);
	public void remove(TipologiaEsame t);
	public void update(TipologiaEsame t);
	public TipologiaEsame findByPrimaryKey(long id);
	public List<TipologiaEsame> findAll();
}
