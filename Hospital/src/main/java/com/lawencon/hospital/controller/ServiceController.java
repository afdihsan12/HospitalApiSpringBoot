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

import com.lawencon.hospital.model.Services;
import com.lawencon.hospital.repository.IServiceRepository;

@RestController
@Controller
@CrossOrigin("*")
public class ServiceController {
	@Autowired
	private IServiceRepository roomstypeRepo;

	@PostMapping("/services")
	public ResponseEntity<?> addRoomsType(@RequestBody Services roomstype) {
		try {
			roomstypeRepo.save(roomstype);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(roomstype);
	}
	@DeleteMapping("/services/{id}")
	public ResponseEntity<?> deleteRoomsType(@PathVariable("id") Long id) {
		Optional<Services> rt = roomstypeRepo.findById(id);
		try {
			roomstypeRepo.delete(rt.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rt.get());
	}
	@PutMapping("/services/{id}")
	public ResponseEntity<?> editRoomsType(@PathVariable("id") Long id,@RequestBody Services rooms) {
		Optional<Services> rt = roomstypeRepo.findById(id);
		rooms.setId(rt.get().getId());
		try {
			roomstypeRepo.save(rooms);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rooms);
	}
	@GetMapping("/services")
	public @ResponseBody List<Services> getAll(){
		return roomstypeRepo.findAll();
	}
	
	@GetMapping("/services/{id}")
	public @ResponseBody Services getAll(@PathVariable("id") long id){
		return roomstypeRepo.findById(id).get();
	}
	
	@GetMapping("/services/search/{code}")
	public @ResponseBody List<Services> getservice(@PathVariable("code") String name){
		return roomstypeRepo.findbyunits(name);
	}

}
