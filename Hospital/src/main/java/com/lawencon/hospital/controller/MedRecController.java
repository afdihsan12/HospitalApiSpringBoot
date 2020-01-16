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
import com.lawencon.hospital.model.MedRec;
import com.lawencon.hospital.repository.IMedRecRepo;

@RestController
@Controller
@CrossOrigin("*")
public class MedRecController {
	
	
	@Autowired
	private IMedRecRepo medRecRep;

	@PostMapping("medrec")
	public ResponseEntity<?> addMedrec(@RequestBody MedRec medrec) {
		try {
			medRecRep.save(medrec);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(medrec);
	}
	
	@GetMapping("medrec")
	public @ResponseBody List<MedRec>  getPatient()	 {
		return medRecRep.findAll();
	}
	
	@GetMapping("medrec/{id}")
	public @ResponseBody MedRec  getPatienta(@PathVariable("id") long id)	 {
		return medRecRep.findById(id).get();
	}
	
	@PutMapping("/medrec/{id}")
	public ResponseEntity<?> editMedRec(@PathVariable("id") Long id,@RequestBody MedRec medrec){
		Optional<MedRec> medrecL = medRecRep.findById(id);
		medrec.setId(medrecL.get().getId());
		try {
			medRecRep.save(medrec);
		} catch (Exception e) {
		 return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(medrec);
	}
	@DeleteMapping("/medrec/{id}")
	public ResponseEntity<?> deleteMedRec(@PathVariable("id") Long id){
		Optional<MedRec> medrecL = medRecRep.findById(id);
		try {
			medRecRep.delete(medrecL.get());;
		} catch (Exception e) {
		 return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(medrecL.get());
	}
	
	@GetMapping("/medrec/search/patient/{name}")
	public ResponseEntity<?> findpatient(@PathVariable("name") String nrp) {
		return ResponseEntity.ok(medRecRep.findPatient(nrp));
	}
	
	@GetMapping("/medrec/search/doctor/{name}")
	public ResponseEntity<?> findDoctor(@PathVariable("name") String nrp) {
		return ResponseEntity.ok(medRecRep.findByDoctor(nrp));
	}

}
