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

import com.lawencon.hospital.model.Rooms;
import com.lawencon.hospital.repository.IRooms;

@Controller
@RestController
@CrossOrigin("*")
public class RoomsController {
	@Autowired
	private IRooms roomstypeRepo;

	@PostMapping("/rooms")
	public ResponseEntity<?> addRoomsType(@RequestBody Rooms roomstype) {
		try {
			roomstypeRepo.save(roomstype);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(roomstype);
	}
	@DeleteMapping("/rooms/{id}")
	public ResponseEntity<?> deleteRoomsType(@PathVariable("id") Long id) {
		Optional<Rooms> rt = roomstypeRepo.findById(id);
		try {
			roomstypeRepo.delete(rt.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rt.get());
	}
	@PutMapping("/rooms/{id}")
	public ResponseEntity<?> editRoomsType(@PathVariable("id") Long id,@RequestBody Rooms rooms) {
		Optional<Rooms> rt = roomstypeRepo.findById(id);
		rooms.setId(rt.get().getId());
		try {
			roomstypeRepo.save(rooms);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rooms);
	}
	@GetMapping("/rooms")
	public @ResponseBody List<Rooms> getAll(){
		return roomstypeRepo.findAll();
	}
	@GetMapping("/rooms/{id}")
	public @ResponseBody Rooms getAll(@PathVariable("id") long id){
		return roomstypeRepo.findById(id).get();
	}
	@GetMapping("/rooms/search/{id}")
	public @ResponseBody List<Rooms> getAllT(@PathVariable("id") String id){
		return roomstypeRepo.getbyCode(id);
	}
}

