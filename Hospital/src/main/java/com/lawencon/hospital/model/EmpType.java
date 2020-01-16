package com.lawencon.hospital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "emptype")
public class EmpType implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idemptype;
	private String description;
	
	@Column(nullable = true)
	private Integer parentid;
	@Column(nullable = false)
	private String code;
	private String name;
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public EmpType() {
		super();
	}

	public Long getIdemptype() {
		return idemptype;
	}

	public void setIdemptype(Long idemptype) {
		this.idemptype = idemptype;
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

}
