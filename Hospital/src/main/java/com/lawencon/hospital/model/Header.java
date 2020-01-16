package com.lawencon.hospital.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Header implements Serializable {
	
	public Header() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idservice")
	private Long id;
	
	@Column(name = "notransaksi",nullable = true)
	private String notr;
	
	@Column(name = "status")
	private String status;
	
	
	@Column(name = "tglmasuk")
	private Date tglmasuk;
	@Column(name = "tglkeluar")
	private Date tglkeluar;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNotr() {
		return notr;
	}
	public void setNotr(String notr) {
		this.notr = notr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTglmasuk() {
		return tglmasuk;
	}
	public void setTglmasuk(Date tglmasuk) {
		this.tglmasuk = tglmasuk;
	}
	public Date getTglkeluar() {
		return tglkeluar;
	}
	public void setTglkeluar(Date tglkeluar) {
		this.tglkeluar = tglkeluar;
	}
	
	

}
