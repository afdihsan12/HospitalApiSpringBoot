package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.MedicineSuppliers;

@Repository
public interface IMedicinerSuppliers extends JpaRepository<MedicineSuppliers, Long> {
	
	@Query("FROM MedicineSuppliers where medicines.name like %?1%")
	List<MedicineSuppliers> getSuplierfindbyObt(String name);
	
	@Query("FROM MedicineSuppliers where suppliers.name like %?1%")
	List<MedicineSuppliers> getSuplierfindbysupp(String name);

}
