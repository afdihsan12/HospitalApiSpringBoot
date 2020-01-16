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
@Table(name = "MedicineSupliers")


public class MedicineSuppliers implements Serializable {

	public MedicineSuppliers() {
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
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idmedicine", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Medicines medicines;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idsupliers", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Suppliers suppliers;
	@Column(name = "tglsuply")
	private Date date;
	@Column(name = "qty")
	private Integer qty;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Medicines getMedicines() {
		return medicines;
	}
	public void setMedicines(Medicines medicines) {
		this.medicines = medicines;
	}
	public Suppliers getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}


}
