package it.uniroma3.db.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


	@Entity
	@Table(name = "risultatiEsame")
	
	public class RisultatiEsame {
	
		@Id
		@ManyToOne
		private Long idEsame;
		
		@Id
		private String descrizione;
		
		@Column
		private String risultato;
		
		public Long getIdEsame() {
			return this.idEsame;
		}
		
		public String getDescrizione() {
			return this.descrizione;
		}
		
		public String getRisultato() {
			return this.risultato;
		}

		public void setIdEsame(Long idEsame) {
			this.idEsame = idEsame;
		}

		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}

		public void setRisultato(String risultato) {
			this.risultato = risultato;
		}
		
		
		
		
		
		
		
		
		
		
	}
	

		
		
	