package net.javaguides.springboot.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name=" mvtstock")
public class Stock implements Serializable {
	@Id
	@GeneratedValue
	private Integer Id;
	
	@Column(name="creatDate", nullable=false)
    private Instant creationDate ;
	
	@Column(name="lastUpdateDate")
    private Instant LastUpdateDate ;  
	@Column(name="datemvt")
	private Date datemvt ;
	
	@Column(name="Quantité")
	private BigDecimal Quantite ;
	
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article ;

	public Stock() {
		super();
	}

	public Stock(Integer id, Instant creationDate, Instant lastUpdateDate, Date datemvt, BigDecimal quantite) {
		super();
		Id = id;
		this.creationDate = creationDate;
		LastUpdateDate = lastUpdateDate;
		this.datemvt = datemvt;
		Quantite = quantite;
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

	public Date getDatemvt() {
		return datemvt;
	}

	public void setDatemvt(Date datemvt) {
		this.datemvt = datemvt;
	}

	public BigDecimal getQuantite() {
		return Quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		Quantite = quantite;
	}

	
	
}
