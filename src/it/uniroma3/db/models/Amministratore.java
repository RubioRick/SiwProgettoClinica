package it.uniroma3.db.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="tab", initialValue=0, allocationSize=99)
public class Amministratore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab1")
	private String id;

	@Column
	private String nome;
	
	@Column
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = PortaleClinica.toSHA1(password);
	}
}
