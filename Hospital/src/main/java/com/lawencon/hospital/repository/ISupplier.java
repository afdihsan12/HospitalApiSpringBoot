package com.lawencon.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.Suppliers;

@Repository
public interface ISupplier extends JpaRepository<Suppliers, Long> {

}
