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
@Table(name = "Rooms", uniqueConstraints = @UniqueConstraint(columnNames = { "roomscode" }))
public class Rooms implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "roomscode",nullable = false)
	private String code;
	@Column(name = "roomsname")
	private String name;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idroomtype", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private RoomsType roomtype;
	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public RoomsType getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(RoomsType roomtype) {
		this.roomtype = roomtype;
	}

}
