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

import com.lawencon.hospital.model.RoomsType;
import com.lawencon.hospital.repository.IRoomsType;

@Controller
@RestController
@CrossOrigin("*")
public class RoomsTypeController {

	@Autowired
	private IRoomsType roomstypeRepo;

	@PostMapping("/roomstype")
	public ResponseEntity<?> addRoomsType(@RequestBody RoomsType roomstype) {
		try {
			roomstypeRepo.save(roomstype);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(roomstype);
	}
	@DeleteMapping("/roomstype/{id}")
	public ResponseEntity<?> deleteRoomsType(@PathVariable("id") Long id) {
		Optional<RoomsType> rt = roomstypeRepo.findById(id);
		try {
			roomstypeRepo.delete(rt.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rt.get());
	}
	@PutMapping("/roomstype/{id}")
	public ResponseEntity<?> editRoomsType(@PathVariable("id") Long id,@RequestBody RoomsType rooms) {
		Optional<RoomsType> rt = roomstypeRepo.findById(id);
		rooms.setId(rt.get().getId());
		try {
			roomstypeRepo.save(rooms);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rooms);
	}
	@GetMapping("/roomstype")
	public @ResponseBody List<RoomsType> getAll(){
		return roomstypeRepo.findAll();
	}
	
	@GetMapping("/roomstype/{id}")
	public @ResponseBody RoomsType get1(@PathVariable("id") long id){
		return roomstypeRepo.findById(id).get();
	}
	
	@GetMapping("/roomstype/search/{id}")
	public @ResponseBody List<RoomsType> get12(@PathVariable("id") String id){
		return roomstypeRepo.getbyCode(id);
	}
}
