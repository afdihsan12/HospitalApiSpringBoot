package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.Services;
@Repository
public interface IServiceRepository extends JpaRepository<Services, Long> {
	
	
	@Query("From Services where units.code = ?1")
	public List<Services> findbyunits(String name);
	
	

}
