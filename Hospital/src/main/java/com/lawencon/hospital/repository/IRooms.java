package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.Rooms;

@Repository
public interface IRooms extends JpaRepository<Rooms, Long>{
	@Query("From Rooms where code like %?1%")
	List<Rooms> getbyCode(String code);

}
