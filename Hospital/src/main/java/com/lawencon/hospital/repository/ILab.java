package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.Labs;
@Repository
public interface ILab extends JpaRepository<Labs, Long> {
	
	@Query("From Labs where name like %?1%")
	List<Labs> findbycode(String code);

}
