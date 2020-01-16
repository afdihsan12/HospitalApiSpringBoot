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
@Table(name = "roomstype", uniqueConstraints = @UniqueConstraint(columnNames = { "roomstypecode" }))
public class RoomsType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "roomstypecode",nullable = false)
		private String code;
		@Column(name = "roomtypenames")
		private String name;
		@Column(name = "description")
		private String description;
		@Column(name = "rate")
		private int rate;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public RoomsType() {
			super();
			// TODO Auto-generated constructor stub
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getRate() {
			return rate;
		}
		public void setRate(int rate) {
			this.rate = rate;
		}
	
		
	

}
