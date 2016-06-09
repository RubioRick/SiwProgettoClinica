package it.uniroma3.db.dao;


import it.uniroma3.db.models.RisultatoEsame;

public interface RisultatiEsameDao {
	public void save(RisultatoEsame r);
	public void remove(RisultatoEsame r);
	public void update(RisultatoEsame r);
	public RisultatoEsame findByPrimaryKey(String id);

}
