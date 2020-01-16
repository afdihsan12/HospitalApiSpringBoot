package com.lawencon.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.lawencon.hospital.model.Units;
import com.lawencon.hospital.repository.IUnits;

@Controller
@RestController
@CrossOrigin("*")
public class UnitsController {

	@Autowired
	private IUnits roomstypeRepo;

	@PostMapping("/units")
	public ResponseEntity<?> addRoomsType(@RequestBody Units roomstype) {
		try {
			roomstypeRepo.save(roomstype);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(roomstype);
	}
	@DeleteMapping("/units/{id}")
	public ResponseEntity<?> deleteRoomsType(@PathVariable("id") Long id) {
		Optional<Units> rt = roomstypeRepo.findById(id);
		try {
			roomstypeRepo.delete(rt.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rt.get());
	}
	@PutMapping("/units/{id}")
	public ResponseEntity<?> editRoomsType(@PathVariable("id") Long id,@RequestBody Units rooms) {
		Optional<Units> rt = roomstypeRepo.findById(id);
		rooms.setId(rt.get().getId());
		try {
			roomstypeRepo.save(rooms);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rooms);
	}
	@GetMapping("/units")
	public @ResponseBody List<Units> getAll(){
		return roomstypeRepo.findAll();
	}
	
	@GetMapping("/units/{id}")
	public @ResponseBody Units getA1(@PathVariable("id") long id){
		return roomstypeRepo.findById(id).get();	
	}
}