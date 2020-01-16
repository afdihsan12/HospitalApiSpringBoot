package com.lawencon.hospital.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "medicalrec")
public class MedRec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idredmec")
	private Long id;
	
	@Column(name = "tgllperiksa")
	private Date tgl;
	
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "idunitdoctor")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private UnitsDoctor unitdoctor;
//	
//	@ManyToOne(fetch = FetchType.LAZY,optional = true)
//	@JoinColumn(name = "idlabrates")
//	@OnDelete(action = OnDeleteAction.NO_ACTION)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	private LabRates labrates;
	
	@Column(name = "history")
	private String history;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "idpatient", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Pasiens patient;

	public MedRec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pasiens getPatient() {
		return patient;
	}

	public void setPatient(Pasiens patient) {
		this.patient = patient;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

	public UnitsDoctor getUnitdoctor() {
		return unitdoctor;
	}

	public void setUnitdoctor(UnitsDoctor unitdoctor) {
		this.unitdoctor = unitdoctor;
	}
	
	
	
	

}
