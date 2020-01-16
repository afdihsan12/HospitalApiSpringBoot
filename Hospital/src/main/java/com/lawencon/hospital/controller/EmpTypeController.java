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

import com.lawencon.hospital.model.EmpType;
import com.lawencon.hospital.repository.IEmpTypeRepp;

@RestController
@Controller
@CrossOrigin("*")
public class EmpTypeController {
	
	@Autowired
	private IEmpTypeRepp empTypeRepp;
	@GetMapping("/roleemp")
	public @ResponseBody List<EmpType> getAllEmpType(){
		return empTypeRepp.findAllt();
	}
	
	@GetMapping("/roleemp/all")
	public @ResponseBody List<EmpType> getAll(){
		return empTypeRepp.findAll();
	}
	
	@GetMapping("/roleemp/{id}")
	public @ResponseBody EmpType get1(@PathVariable("id") long id){
		return empTypeRepp.findById(id).get();
	}
	
	@GetMapping("/roleemp/parent")
	public @ResponseBody List<EmpType> getParent(){
		return empTypeRepp.findParent();
	}
	
	@GetMapping("/roleemp/seacrh/{code}")
	public @ResponseBody List<EmpType> getPa(@PathVariable("code") String code){
		return empTypeRepp.findP(code);
	}

	@PostMapping("/roleemp")
	public ResponseEntity<?> add(@RequestBody EmpType emp){
		try {
			empTypeRepp.save(emp);	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emp);
	}
	
	@PutMapping("roleemp/{id}")
	public ResponseEntity<?> editEmptype(@PathVariable("id") long id,@RequestBody EmpType emptype) {
		Optional<EmpType> emplo = empTypeRepp.findById(id);
		emptype.setIdemptype(emplo.get().getIdemptype());
		try {
			empTypeRepp.save(emptype);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emptype);
	}
	
	@DeleteMapping("roleemp/{id}")
	public ResponseEntity<?> deleteEmptype(@PathVariable("id") long id) {
		Optional<EmpType> emplo = empTypeRepp.findById(id);
		try {
			empTypeRepp.delete(emplo.get());;
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(emplo.get());
	}
	
	
}
