package com.lawencon.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.hospital.model.Header;

@Repository
public interface IHeaderRepo extends JpaRepository<Header, Long>{

}
