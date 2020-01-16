package com.lawencon.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.Medicines;

@Repository
public interface IMedicine extends JpaRepository<Medicines, Long> {

}
