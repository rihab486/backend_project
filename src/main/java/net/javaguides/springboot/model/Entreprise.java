package net.javaguides.springboot.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name=" entreprise ")
public class Entreprise implements Serializable{
	@Id
	@GeneratedValue
	private Integer Id;
	
	@Column(name="creatDate", nullable=false)
    private Instant creationDate ;
	
	@Column(name="lastUpdateDate")
    private Instant LastUpdateDate ;
	@Column(name = "nom")
	private String nom;
	@Column(name = "description")
	private String description;
	
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "email")
	private String email;
	@Column(name = "numerotel")
	private String NumTel;
	@Column(name = "numerofax")
	private String NumFax;
	@Column(name = "siteweb")
	private String sitew;
	
	@OneToMany(mappedBy ="entreprise")
	private List<User> utilisateur ;
	@OneToMany(mappedBy ="entreprise")
	private List<Article> article ;
	public Entreprise() {
		super();
	}
	public Entreprise(Integer id, Instant creationDate, Instant lastUpdateDate, String nom, String description,
			String adresse, String email, String numTel, String numFax, String sitew) {
		super();
		Id = id;
		this.creationDate = creationDate;
		LastUpdateDate = lastUpdateDate;
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.email = email;
		NumTel = numTel;
		NumFax = numFax;
		this.sitew = sitew;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumTel() {
		return NumTel;
	}
	public void setNumTel(String numTel) {
		NumTel = numTel;
	}
	public String getNumFax() {
		return NumFax;
	}
	public void setNumFax(String numFax) {
		NumFax = numFax;
	}
	public String getSitew() {
		return sitew;
	}
	public void setSitew(String sitew) {
		this.sitew = sitew;
	}
	
}
