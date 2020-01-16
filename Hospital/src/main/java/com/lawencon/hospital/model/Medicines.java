package com.lawencon.hospital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "medicines",uniqueConstraints = @UniqueConstraint(columnNames = "codeobat"))
public class Medicines implements Serializable{

	public Medicines() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "codeobat",nullable = false)
	private String code;
	@Column(name = "nameobat")
	private String name;
	@Column(name = "unitsobat")
	private String units;
	private Integer rate;
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
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	
	
}
