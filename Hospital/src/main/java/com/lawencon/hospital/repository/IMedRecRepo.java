package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.MedRec;


@Repository
public interface IMedRecRepo extends JpaRepository<MedRec, Long>{
	
	@Query("From MedRec where patient.regNum = ?1 ORDER BY tgl ASC")
	List<MedRec> findPatient(String medredNum);
	
	@Query("From MedRec where unitdoctor.emp.idemp = ?1 ORDER BY tgl ASC")
	List<MedRec> findByDoctor(String nrp);
}
