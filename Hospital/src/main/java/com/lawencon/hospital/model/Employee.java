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
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(columnNames = { "nrp" }))
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idemp;

	@Column(name = "nrp",nullable = false)
	private String nrp;
	private String name;
	private String alamat;
	private String notelp;
	private String email;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idemptype", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private EmpType emptype;

	public Employee() {
		super();
	}

	public Long getIdemp() {
		return idemp;
	}

	public void setIdemp(Long idemp) {
		this.idemp = idemp;
	}

	public String getNrp() {
		return nrp;
	}

	public void setNrp(String nrp) {
		this.nrp = nrp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNotelp() {
		return notelp;
	}

	public void setNotelp(String notelp) {
		this.notelp = notelp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmpType getEmptype() {
		return emptype;
	}

	public void setEmptype(EmpType emptype) {
		this.emptype = emptype;
	}

}
