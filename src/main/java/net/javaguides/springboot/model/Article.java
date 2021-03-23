package net.javaguides.springboot.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Article")
public class Article implements Serializable{
	@Id
	@GeneratedValue
	private Integer Id;
	
	@Column(name="creatDate", nullable=false)
    private Instant creationDate ;
	
	@Column(name="lastUpdateDate")
    private Instant LastUpdateDate ;
	
	@Column(name="codearticle")
	private String CodeArticle ;
	
	@Column(name="designation")
	private String designation ;
	
	@Column(name="prixYnitaireHt")
	private BigDecimal prixYnitaireHt;
	
	@ManyToOne
	@JoinColumn(name="idcategory")
	private Category category;

	@OneToMany(mappedBy ="articles")
	private List<LigneCommandeClient> lcmdclient;
	@OneToMany(mappedBy ="articles")
	private List<LigneCommandeFournisseur> lcmdfournisseur;
	
	@OneToMany(mappedBy ="articles")
	private List<LigneVente> lvente;
	
	@ManyToOne
	@JoinColumn(name="identreprise")
	private Entreprise entreprise ;
	
	@OneToMany(mappedBy ="article")
	private List<Stock> stk;
	
	@OneToMany(mappedBy ="article")
	private List<CommandeClient> cmdclient;
	
	public Article() {
		super();
	}

	public Article(Integer id, Instant creationDate, Instant lastUpdateDate, String codeArticle, String designation,
			BigDecimal prixYnitaireHt) {
		super();
		Id = id;
		this.creationDate = creationDate;
		LastUpdateDate = lastUpdateDate;
		CodeArticle = codeArticle;
		this.designation = designation;
		this.prixYnitaireHt = prixYnitaireHt;
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

	public String getCodeArticle() {
		return CodeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		CodeArticle = codeArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getPrixYnitaireHt() {
		return prixYnitaireHt;
	}

	public void setPrixYnitaireHt(BigDecimal prixYnitaireHt) {
		this.prixYnitaireHt = prixYnitaireHt;
	}
	

}
