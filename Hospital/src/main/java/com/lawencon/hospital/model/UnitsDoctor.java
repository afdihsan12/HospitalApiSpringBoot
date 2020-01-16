package com.lawencon.hospital.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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
@Table(name = "UnitsDoctor", uniqueConstraints = @UniqueConstraint(columnNames = { "idservice","tanggal","jam" }))
public class UnitsDoctor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "idemp", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Employee emp;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "idservice", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Services servie;
	
	
	@Column(name = "tanggal")
	private Date tanggal;
	public Long getId() {
		return id;
	}
	public UnitsDoctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	public Date getTanggal() {
		return tanggal;
	}
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	public Time getJam() {
		return jam;
	}
	public void setJam(Time jam) {
		this.jam = jam;
	}
	@Column(name = "jam")
	private Time jam;
	public Services getServie() {
		return servie;
	}
	public void setServie(Services servie) {
		this.servie = servie;
	}

}
