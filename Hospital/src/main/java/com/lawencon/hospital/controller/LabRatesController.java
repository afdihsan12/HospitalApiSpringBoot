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

import com.lawencon.hospital.model.LabRates;
import com.lawencon.hospital.repository.ILabRates;

@RestController
@Controller
@CrossOrigin("*")
public class LabRatesController {
	@Autowired
	private ILabRates roomstypeRepo;

	@PostMapping("/labsrates")
	public ResponseEntity<?> addRoomsType(@RequestBody LabRates roomstype) {
		try {
			roomstypeRepo.save(roomstype);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(roomstype);
	}
	@DeleteMapping("/labsrates/{id}")
	public ResponseEntity<?> deleteRoomsType(@PathVariable("id") Long id) {
		Optional<LabRates> rt = roomstypeRepo.findById(id);
		try {
			roomstypeRepo.delete(rt.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rt.get());
	}
	@PutMapping("/labsrates/{id}")
	public ResponseEntity<?> editRoomsType(@PathVariable("id") Long id,@RequestBody LabRates rooms) {
		Optional<LabRates> rt = roomstypeRepo.findById(id);
		rooms.setId(rt.get().getId());
		try {
			roomstypeRepo.save(rooms);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rooms);
	}
	@GetMapping("/labsrates")
	public @ResponseBody List<LabRates> getAll(){
		return roomstypeRepo.findAll();
	}
	
	@GetMapping("/labsrates/{id}")
	public @ResponseBody LabRates get1(@PathVariable("id") long id){
		return roomstypeRepo.findById(id).get();
	}
	
	@GetMapping("/labsrates/search/{name}")
	public @ResponseBody List<LabRates> getqq1(@PathVariable("name") String id){
		return roomstypeRepo.findbycode(id);
	}
	
	@GetMapping("/labsrates/search/labs/{name}")
	public @ResponseBody List<LabRates> getas(@PathVariable("name") String id){
		return roomstypeRepo.findbycodeLabs(id);
	}

}
