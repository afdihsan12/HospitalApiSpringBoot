package com.lawencon.hospital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "services",uniqueConstraints = @UniqueConstraint(columnNames = "codeservices"))
public class Services implements Serializable{

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codeservices",nullable = false)
	private String code;
	@Column(name = "nameservices")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "rateservices")
	private int rate;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "idunits", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Units units;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public Units getUnits() {
		return units;
	}
	public void setUnits(Units units) {
		this.units = units;
	}

}
