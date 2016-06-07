package it.uniroma3.db.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "esami")
public class Esame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private TipologiaEsame tipologiaEsame;
	
	@ManyToOne
	private Medico medicoResponsabile;
	
	@ManyToOne
	private Paziente paziente;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date data;
	
	@OneToMany(mappedBy = "idEsame")
	private List<RisultatoEsame> risultati;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public Medico getMedicoResponsabile() {
		return medicoResponsabile;
	}

	public void setMedicoResponsabile(Medico medicoResponsabile) {
		this.medicoResponsabile = medicoResponsabile;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Esame"); 
		sb.append("{id=").append(id); 
		sb.append(", tipologiaEsame='").append(tipologiaEsame);
		sb.append(", paziente='").append(paziente);
		sb.append(", medico='").append(medicoResponsabile);
		sb.append(", data=").append(data); 
		sb.append("}\n");
		return sb.toString();
	}
	
}
