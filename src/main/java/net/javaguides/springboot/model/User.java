package net.javaguides.springboot.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Utilisateur ")
public class User implements Serializable {
	@Id
	@GeneratedValue
	private Integer Id;
	
	@Column(name="creatDate", nullable=false)
    private Instant creationDate ;
	
	@Column(name="lastUpdateDate")
    private Instant LastUpdateDate ;
	@Column(name="nom")
	private String nom ;
	
	@Column(name="prenom")
	private String prenom ;
	@Column(name="adresse")
	private String adresse;
	@Column(name="numTel")
	private String numtel;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@ManyToOne
	@JoinColumn(name="identreprise")
	private Entreprise entreprise ;
	public User() {
		super();
	}
	public User(Integer id, Instant creationDate, Instant lastUpdateDate, String nom, String prenom, String adresse,
			String numtel, String email, String password) {
		super();
		Id = id;
		this.creationDate = creationDate;
		LastUpdateDate = lastUpdateDate;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numtel = numtel;
		this.email = email;
		this.password = password;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Instant getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}
	public Instant getLastUpdateDate() {
		return LastUpdateDate;
	}
	public void setLastUpdateDate(Instant lastUpdateDate) {
		LastUpdateDate = lastUpdateDate;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumtel() {
		return numtel;
	}
	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
