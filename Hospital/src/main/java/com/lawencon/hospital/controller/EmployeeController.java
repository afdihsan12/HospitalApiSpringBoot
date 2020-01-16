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


import com.lawencon.hospital.model.Employee;
import com.lawencon.hospital.repository.IEmpRep;

@CrossOrigin(origins = "*")
@RestController
@Controller			
public class EmployeeController {

	@Autowired
	private IEmpRep emprep;
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee empployeet) {
		try {
			emprep.save(empployeet);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(empployeet);
	}	
	
	@GetMapping("/employee")
	public @ResponseBody List<Employee>  getPatient() {
		return emprep.orderByCode();
	}
	
	@PutMapping("employee/{id}")
	public ResponseEntity<?> editEmployee(@PathVariable("id") long id,@RequestBody Employee employee) {
		Optional<Employee> emplo = emprep.findById(id);
		employee.setIdemp(emplo.get().getIdemp());
		try {
		emprep.save(employee);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().body(employee);
	}
			
	
	@GetMapping("employee/search/type/{name}")
	public @ResponseBody List<Employee> getFine(@PathVariable("name") String name) {
		return emprep.findByFirstName(name);
	}
	
	@GetMapping("employee/search/{name}")
	public @ResponseBody List<Employee> getF(@PathVariable("name") String name) {
		return emprep.findByFirst(name);
	}
	
	@GetMapping("employee/{name}")
	public @ResponseBody Employee getFine(@PathVariable("name") long name) {
		return emprep.findById(name).get()	;
	}
		
	@DeleteMapping("employee/{id}")
	public ResponseEntity<?> DeleteEmployee(@PathVariable("id") long id,Employee employee) {
		Optional<Employee> emplo = emprep.findById(id);
		employee = emplo.get();
			try {	
		emprep.delete(employee);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().body(employee);
	}
	
	
	
	
			
}
