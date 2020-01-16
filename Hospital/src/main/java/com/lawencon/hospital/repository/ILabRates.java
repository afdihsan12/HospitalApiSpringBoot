package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.LabRates;

@Repository
public interface ILabRates extends JpaRepository<LabRates, Long> {
	
	@Query("FROM LabRates where pelayanan like %?1%")
	List<LabRates> findbycode(String name);
	
	@Query("FROM LabRates where labs.name like %?1%")
	List<LabRates> findbycodeLabs(String name);

}
