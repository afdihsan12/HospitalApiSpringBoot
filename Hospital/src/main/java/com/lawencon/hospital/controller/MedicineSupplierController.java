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
import com.lawencon.hospital.model.MedicineSuppliers;
import com.lawencon.hospital.repository.IMedicinerSuppliers;

@RestController
@Controller
@CrossOrigin("*")
public class MedicineSupplierController {

	@Autowired
	private IMedicinerSuppliers roomstypeRepo;

	@PostMapping("/medicines/supplier")
	public ResponseEntity<?> addRoomsType(@RequestBody MedicineSuppliers roomstype) {
		try {
			roomstypeRepo.save(roomstype);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(roomstype);
	}
	@DeleteMapping("/medicines/supplier/{id}")
	public ResponseEntity<?> deleteRoomsType(@PathVariable("id") Long id) {
		Optional<MedicineSuppliers> rt = roomstypeRepo.findById(id);
		try {
			roomstypeRepo.delete(rt.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rt.get());
	}
	@PutMapping("/medicines/supplier/{id}")
	public ResponseEntity<?> editRoomsType(@PathVariable("id") Long id,@RequestBody MedicineSuppliers rooms) {
		Optional<MedicineSuppliers> rt = roomstypeRepo.findById(id);
		rooms.setId(rt.get().getId());
		try {
			roomstypeRepo.save(rooms);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rooms);
	}
	@GetMapping("/medicines/supplier")
	public @ResponseBody List<MedicineSuppliers> getAll(){
		return roomstypeRepo.findAll();
	}
	
	@GetMapping("/medicines/supplier/{id}")
	public @ResponseBody MedicineSuppliers getA1(@PathVariable("id") long id){
		return roomstypeRepo.findById(id).get();
	}
	
	
	@GetMapping("/medicines/supplier/supplier/{code}")
	public @ResponseBody List<MedicineSuppliers> getsup(@PathVariable("code") String code){
		return roomstypeRepo.getSuplierfindbysupp(code);
	}

	@GetMapping("/medicines/supplier/obat/{code}")
	public @ResponseBody List<MedicineSuppliers> getoba(@PathVariable("code") String code){
		return roomstypeRepo.getSuplierfindbyObt(code);
	}
	
	
}	
