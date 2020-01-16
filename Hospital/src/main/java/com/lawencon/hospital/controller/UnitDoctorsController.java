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

import com.lawencon.hospital.model.UnitsDoctor;
import com.lawencon.hospital.repository.IUnitsDoctor;

@RestController
@Controller
@CrossOrigin("*")
public class UnitDoctorsController {
	@Autowired
	private IUnitsDoctor roomstypeRepo;

	@PostMapping("/unitsdoctor")
	public ResponseEntity<?> addRoomsType(@RequestBody UnitsDoctor roomstype) {
		try {
			roomstypeRepo.save(roomstype);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(roomstype);
	}
	@DeleteMapping("/unitsdoctor/{id}")
	public ResponseEntity<?> deleteRoomsType(@PathVariable("id") Long id) {
		Optional<UnitsDoctor> rt = roomstypeRepo.findById(id);
		try {
			roomstypeRepo.delete(rt.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rt.get());
	}
	@PutMapping("/unitsdoctor/{id}")
	public ResponseEntity<?> editRoomsType(@PathVariable("id") Long id,@RequestBody UnitsDoctor rooms) {
		Optional<UnitsDoctor> rt = roomstypeRepo.findById(id);
		rooms.setId(rt.get().getId());
		try {
			roomstypeRepo.save(rooms);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rooms);
	}
	@GetMapping("/unitsdoctor")
	public @ResponseBody List<UnitsDoctor> getAll(){
		return roomstypeRepo.findAll();
	}
	
	@GetMapping("/unitsdoctor/{id}")
	public @ResponseBody UnitsDoctor getA1(@PathVariable("id") long id){
		return roomstypeRepo.findById(id).get();
	}

}
