package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.ServicePatient;

@Repository
public interface IServicePatient extends JpaRepository<ServicePatient, Long>{
	
	@Query("From ServicePatient where labrates != null")
	List<ServicePatient> findLabservice();
	
	@Query("From ServicePatient where  unitdoctor != null")
	List<ServicePatient> findUnitservice();
	
	@Query("From ServicePatient where  rooms != null")
	List<ServicePatient> findroom();
	
	@Query("From ServicePatient where  medicine != null")
	List<ServicePatient> findMedicine();
	
	@Query("From ServicePatient where  medicine != null and patient.regNum =?1")
	List<ServicePatient> findMedicinebyregnum(String regnum);

	@Query("From ServicePatient where  labrates != null and patient.regNum =?1")
	List<ServicePatient> findlabbyregnum(String regnum);
	
	@Query("From ServicePatient where  unitdoctor != null and patient.regNum =?1")
	List<ServicePatient> findunitsbyregnum(String regnum);
	
	@Query("From ServicePatient where  rooms != null and patient.regNum =?1")
	List<ServicePatient> findRoomsbyregnum(String regnum);
	
	
	
	
	@Query("From ServicePatient where patient.regNum = ?1")
	List<ServicePatient> getbillbypatient(String name);
	
	@Query("FROM ServicePatient where head.id = ?1")
	List<ServicePatient> getDetail(Long notr);
	
}
