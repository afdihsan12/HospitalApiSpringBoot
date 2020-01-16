package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.Employee;


@Repository
public interface IEmpRep extends JpaRepository<Employee, Long>{

	@Query("FROM Employee  WHERE emptype.code like %?1% ORDER by name" )
    List<Employee> findByFirstName(String firstName);
	
	@Query("FROM Employee  WHERE name like %?1% ORDER by name" )
    List<Employee> findByFirst(String firstName);
	
	@Query("FROM Employee ORDER by emptype.code,name")
	List<Employee> orderByCode();

}
