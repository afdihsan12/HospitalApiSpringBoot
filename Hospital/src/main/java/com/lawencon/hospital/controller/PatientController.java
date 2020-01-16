package com.lawencon.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.hospital.model.Pasiens;
import com.lawencon.hospital.repository.IPasiensRepository;

@RestController
@Controller
@CrossOrigin("*")
public class PatientController {

	@Autowired
	private IPasiensRepository pasiensRepo;

	@PostMapping("/patient")
	public ResponseEntity<?> addPatient(@RequestBody Pasiens patient) {
		try {
			pasiensRepo.save(patient);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}

	@PutMapping("/patient/{id}")
	public ResponseEntity<?> updateatient(@RequestBody Pasiens patient, @PathVariable("id") long id) {
		try {
			Optional<Pasiens> patients = pasiensRepo.findById(id);
			patient.setId(patients.get().getId());
			pasiensRepo.save(patient);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}

	@DeleteMapping("/patient/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		Optional<Pasiens> patient = pasiensRepo.findById(id);
		try {
			pasiensRepo.delete(patient.get());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(patient);
	}

	@GetMapping("/patient")
	public @ResponseBody List<Pasiens> getAll() {
		List<Pasiens> patient = pasiensRepo.findAll();
		return patient;
	}
	
	@GetMapping("/patient/{id}")
	public @ResponseBody Pasiens get1(@PathVariable("id") long id ) {
		
		return pasiensRepo.findById(id).get();
	}

	@GetMapping("/patient/search/{name}")
	public ResponseEntity<?> getPatientByName(@PathVariable("name") String name) {
		try {
			pasiensRepo.findByFirstName(name);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pasiensRepo.findByFirstName(name));
	}
}
