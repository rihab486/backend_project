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
@Table(name="category")
public class Category implements Serializable {
	@Id
	@GeneratedValue
	private Integer Id;
	
	@Column(name="creatDate", nullable=false)
    private Instant creationDate ;
	
	@Column(name="lastUpdateDate")
    private Instant LastUpdateDate ;
	@Column(name="codecategory")
	private String Code ;
	
	@Column(name="Designation")
	private String designation ;
	
	@OneToMany(mappedBy="category")
	private List<Article> articles ;

	public Category() {
		super();
	}

	public Category(Integer id, Instant creationDate, Instant lastUpdateDate, String code, String designation) {
		super();
		Id = id;
		this.creationDate = creationDate;
		LastUpdateDate = lastUpdateDate;
		Code = code;
		this.designation = designation;
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
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
