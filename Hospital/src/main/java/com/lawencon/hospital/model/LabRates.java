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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "labrates")
public class LabRates implements Serializable {

	public LabRates() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "idlabs", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Labs labs;
	@Column(name = "pelayanan")
	private String pelayanan;
	@Column(name = "rate")
	private int rate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Labs getLabs() {
		return labs;
	}
	public void setLabs(Labs labs) {
		this.labs = labs;
	}
	public String getPelayanan() {
		return pelayanan;
	}
	public void setPelayanan(String pelayanan) {
		this.pelayanan = pelayanan;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
}
