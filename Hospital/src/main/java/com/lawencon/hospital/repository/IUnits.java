package com.lawencon.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.Units;

@Repository
public interface IUnits extends JpaRepository<Units, Long>{

}
