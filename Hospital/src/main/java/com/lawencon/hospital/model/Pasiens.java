package com.lawencon.hospital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Date;

@Entity
@Table(name = "pasiens",uniqueConstraints = { @UniqueConstraint(columnNames = {"regnum"}),@UniqueConstraint(columnNames = "medrecnumber")})

public class Pasiens implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "regnum",nullable = false)
	private String regNum;
	@Column(name = "name")
	private String name;
	@Column(name = "medrecnumber",nullable = false)
	
	private String medRecNumber;
	@Column(name = "dob")
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(name = "gender")
	private String gender;
	@Column(name = "addres")
	private String addres;
	@Column(name = "phonenumber")
	private String phonenumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegNum() {
		return regNum;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMedRecNumber() {
		return medRecNumber;
	}
	public void setMedRecNumber(String medRecNumber) {
		this.medRecNumber = medRecNumber;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	public Pasiens() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	
	

}
