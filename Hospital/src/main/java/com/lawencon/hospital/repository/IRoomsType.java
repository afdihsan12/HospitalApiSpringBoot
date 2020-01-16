package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.RoomsType;

@Repository
public interface IRoomsType extends JpaRepository<RoomsType,Long> {
	@Query("From RoomsType where code like %?1%")
	List<RoomsType> getbyCode(String code);

}
