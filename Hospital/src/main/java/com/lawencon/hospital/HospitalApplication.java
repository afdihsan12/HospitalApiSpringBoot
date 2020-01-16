package com.lawencon.hospital;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@AutoConfigurationPackage
@ComponentScan(basePackages  = {"com."})
@EntityScan(basePackages = {"com.lawencon.hospital.model"})
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	
	
}
