package net.javaguides.springboot.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
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
@Table(name="CommandeClient")
public class CommandeClient implements Serializable {
	@Id
	@GeneratedValue
	private Integer Id;
	
	@Column(name="creatDate", nullable=false)
    private Instant creationDate ;
	
	@Column(name="lastUpdateDate")
    private Instant LastUpdateDate ;
	
	@Column(name="code")
	private String code;
	
	@Column(name="datecommande")
	private Date datecommande ;

	@ManyToOne
	@JoinColumn(name="idclient")
	private Client client ;
	
	@OneToMany(mappedBy ="commandeclient")
	private List<LigneCommandeClient> lignecommandeclient;
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article ;
	
	public CommandeClient() {
		super();
	}

	public CommandeClient(Integer id, Instant creationDate, Instant lastUpdateDate, String code, Date datecommande) {
		super();
		Id = id;
		this.creationDate = creationDate;
		LastUpdateDate = lastUpdateDate;
		this.code = code;
		this.datecommande = datecommande;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDatecommande() {
		return datecommande;
	}

	public void setDatecommande(Date datecommande) {
		this.datecommande = datecommande;
	}
	
}
