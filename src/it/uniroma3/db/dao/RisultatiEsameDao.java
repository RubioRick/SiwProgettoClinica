package it.uniroma3.db.dao;


import it.uniroma3.db.models.RisultatoEsame;

public interface RisultatiEsameDao {
	public RisultatoEsame save(Long id,String descrizione, String risultato);
	public void remove(RisultatoEsame r);
	public void update(RisultatoEsame r);
	public RisultatoEsame findByPrimaryKey(Long id);

}