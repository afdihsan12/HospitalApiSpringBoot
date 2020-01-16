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

import com.lawencon.hospital.model.Header;
import com.lawencon.hospital.repository.IHeaderRepo;

@Controller
@RestController
@CrossOrigin("*")
public class HeaderController {
	
	@Autowired
	private IHeaderRepo empTypeRepp;
	
	
	@GetMapping("/header/")
	public @ResponseBody List<Header> getAll(){
		return empTypeRepp.findAll();
	}
	
	@GetMapping("/header/{id}")
	public @ResponseBody Header get1(@PathVariable("id") long id){
		return empTypeRepp.findById(id).get();
	}
	
	
	
	

	@PostMapping("/header")
	public ResponseEntity<?> add(@RequestBody Header emp){
		try {
			empTypeRepp.save(emp);	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emp);
	}
	
	@PutMapping("header/{id}")
	public ResponseEntity<?> editEmptype(@PathVariable("id") long id,@RequestBody Header emptype) {
		Optional<Header> emplo = empTypeRepp.findById(id);
		emptype.setId(emplo.get().getId());
		try {
			empTypeRepp.save(emptype);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emptype);
	}
	
	@DeleteMapping("header/{id}")
	public ResponseEntity<?> deleteEmptype(@PathVariable("id") long id) {
		Optional<Header> emplo = empTypeRepp.findById(id);
		try {
			empTypeRepp.delete(emplo.get());;
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emplo.get());
	}
	

}
