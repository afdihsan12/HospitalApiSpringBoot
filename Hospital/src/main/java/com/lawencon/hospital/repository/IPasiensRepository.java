package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.Pasiens;

@Repository
public interface IPasiensRepository extends JpaRepository<Pasiens, Long> {
	
	
	@Query("FROM Pasiens  WHERE regNum = ?1" )
    List<Pasiens> findByFirstName(String firstName);
 

}
