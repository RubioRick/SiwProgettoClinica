package it.uniroma3.db.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "risultatiEsame")
public class RisultatoEsame {
	
	@Id
	@ManyToOne
	private long idEsame;
	
	@Id
	private String descrizione;
	
	@Column
	private String risultato;

	public long getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(long idEsame) {
		this.idEsame = idEsame;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getRisultato() {
		return risultato;
	}

	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}
	
}
