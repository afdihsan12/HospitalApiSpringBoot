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
	@Table(name = "servicepasien")
	public class ServicePatient implements Serializable{
	
		public ServicePatient() {
			super();
			// TODO Auto-generated constructor stub
		}
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "idservice")
		private Long id;
		
		@ManyToOne(fetch = FetchType.LAZY,optional = false)
		@JoinColumn(name = "idheader")
		@OnDelete(action = OnDeleteAction.NO_ACTION)
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Header head;
		
	
		@ManyToOne(fetch = FetchType.LAZY,optional = true)
		@JoinColumn(name = "service")
		@OnDelete(action = OnDeleteAction.NO_ACTION)
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Services service;
		
		@ManyToOne(fetch = FetchType.LAZY,optional = true)
		@JoinColumn(name = "idlabrates")
		@OnDelete(action = OnDeleteAction.NO_ACTION)
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private LabRates labrates;
		
		@ManyToOne(fetch = FetchType.LAZY,optional = true)
		@JoinColumn(name = "idmedicine")
		@OnDelete(action = OnDeleteAction.NO_ACTION)
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Medicines medicine;
		
		
		@ManyToOne(fetch = FetchType.LAZY,optional = false)
		@JoinColumn(name = "idpatient")
		@OnDelete(action = OnDeleteAction.NO_ACTION)
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Pasiens patient;
		
		@ManyToOne(fetch = FetchType.LAZY,optional = true)
		@JoinColumn(name = "idrooms", nullable = true)
		@OnDelete(action = OnDeleteAction.NO_ACTION)
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Rooms rooms;
		@Column(name = "rate")
		private Integer rate;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		
		public LabRates getLabrates() {
			return labrates;
		}
		public void setLabrates(LabRates labrates) {
			this.labrates = labrates;
		}
		public Medicines getMedicine() {
			return medicine;
		}
		public void setMedicine(Medicines medicine) {
			this.medicine = medicine;
		}
		public Rooms getRooms() {
			return rooms;
		}
		public void setRooms(Rooms rooms) {
			this.rooms = rooms;
		}
		public Integer getRate() {
			return rate;
		}
		public void setRate(Integer rate) {
			this.rate = rate;
		}
		public Pasiens getPatient() {
			return patient;
		}
		public void setPatient(Pasiens patient) {
			this.patient = patient;
		}
		public Header getHead() {
			return head;
		}
		public void setHead(Header head) {
			this.head = head;
		}
		public Services getService() {
			return service;
		}
		public void setService(Services service) {
			this.service = service;
		}
			
	}
