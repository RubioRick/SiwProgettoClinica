package it.uniroma3.db.dao;


import java.util.Date;
import java.util.List;

import it.uniroma3.db.models.Esame;
import it.uniroma3.db.models.Medico;
import it.uniroma3.db.models.Paziente;
import it.uniroma3.db.models.TipologiaEsame;

public interface EsameDao {
	public Esame save(TipologiaEsame tipologiaEsame, Long idMedico, String cf, Date data);
	public void remove(Esame e);
	public void update(Esame e);
	public Esame findByPromaryKey(Long id);
	public List<Esame> findAll();
	public List<Esame> getEsamiPerPaziente(Paziente p);
	public List<Esame> trovaEsamiPaziente(String cf);

}
