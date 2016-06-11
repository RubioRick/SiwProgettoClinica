package it.uniroma3.db.dao;



public interface AmministrazioneDao {
	public void save(Amministrazione a);
	public void remove(Amministrazione a);
	public void update(Amministrazione a);
	public Amministrazione findByPrimaryKey(String id);

}