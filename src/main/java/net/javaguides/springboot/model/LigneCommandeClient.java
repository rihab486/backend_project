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
@Table(name="LigneCommandeClient")
public class LigneCommandeClient implements Serializable {
	@Id
	@GeneratedValue
	private Integer Id;
	
	@Column(name="creatDate", nullable=false)
    private Instant creationDate ;
	
	@Column(name="lastUpdateDate")
    private Instant LastUpdateDate ;

	@ManyToOne
	@JoinColumn(name="idcommandeclient")
	private CommandeClient commandeclient;
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article articles ;
	
	public LigneCommandeClient() {
		super();
	}

	public LigneCommandeClient(Integer id, Instant creationDate, Instant lastUpdateDate) {
		super();
		Id = id;
		this.creationDate = creationDate;
		LastUpdateDate = lastUpdateDate;
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
	
	
}
