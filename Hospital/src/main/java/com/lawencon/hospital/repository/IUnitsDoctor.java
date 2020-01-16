package com.lawencon.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.UnitsDoctor;
@Repository
public interface IUnitsDoctor extends JpaRepository<UnitsDoctor, Long> {

}
