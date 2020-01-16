package com.lawencon.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.EmpType;


@Repository
public interface IEmpTypeRepp extends JpaRepository<EmpType, Long>  {
	@Query("FROM EmpType where parentid !=null order by parentid ")
	List<EmpType> findAllt();
	
	@Query("FROM EmpType where parentid is null order by code")
	List<EmpType> findParent();
	
	@Query("FROM EmpType where code like %?1%")
	List<EmpType> findP(String code);
}
