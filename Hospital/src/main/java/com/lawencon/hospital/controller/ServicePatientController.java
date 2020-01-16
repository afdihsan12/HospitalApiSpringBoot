package com.lawencon.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.hospital.model.ServicePatient;
import com.lawencon.hospital.repository.IServicePatient;

@RestController
@Controller
public class ServicePatientController {

	@Autowired
	private IServicePatient roomstypeRepo;

	@PostMapping("/hospitalservice/patient/")
	public ResponseEntity<?> addRoomsType(@RequestBody ServicePatient roomstype) {
		try {
			roomstypeRepo.save(roomstype);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(roomstype);
	}


	@PutMapping("hospitalservice/patient/{id}")
	public ResponseEntity<?> editRoomsType(@PathVariable("id") Long id, @RequestBody ServicePatient rooms) {
		Optional<ServicePatient> rt = roomstypeRepo.findById(id);
		rooms.setId(rt.get().getId());
		try {
			roomstypeRepo.save(rooms);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			// TODO: handle exception
		}
		return ResponseEntity.ok(rooms);
	}

	@GetMapping("/hospitalservice/")
	public @ResponseBody List<ServicePatient> getAll() {
		return roomstypeRepo.findAll();
	}
	
	@GetMapping("/hospitalservice/search/{name}")
	public @ResponseBody List<ServicePatient> getAllPatimet(@PathVariable("name") String name) {
		return roomstypeRepo.getbillbypatient(name);
	}

	

	@GetMapping("/hospitalservice/patient/labservice")
	public @ResponseBody List<ServicePatient> getlab() {
		return roomstypeRepo.findLabservice();
	}

	@GetMapping("/hospitalservice/patient/labservice/{reg}")
	public @ResponseBody List<ServicePatient> getlabname(@PathVariable("reg") String reg) {
		return roomstypeRepo.findlabbyregnum(reg);
	}

	@GetMapping("/hospitalservice/patient/unit")
	public @ResponseBody List<ServicePatient> getunit() {
		return roomstypeRepo.findUnitservice();
	}

	@GetMapping("/hospitalservice/patient/unit/{reg}")
	public @ResponseBody List<ServicePatient> getunitbyname(@PathVariable("reg") String reg) {
		return roomstypeRepo.findunitsbyregnum(reg);
	}

	@GetMapping("/hospitalservice/patient/rooms")
	public @ResponseBody List<ServicePatient> getrooms() {
		return roomstypeRepo.findroom();
	}

	@GetMapping("/hospitalservice/patient/rooms/{reg}")
	public @ResponseBody List<ServicePatient> getroomsname(@PathVariable("reg") String regnum) {
		return roomstypeRepo.findRoomsbyregnum(regnum);
	}

	@GetMapping("/hospitalservice/patient/medicine")
	public @ResponseBody List<ServicePatient> getMedicine() {
		return roomstypeRepo.findMedicine();
	}

	@GetMapping("/hospitalservice/patient/medicine/{reg}")
	public @ResponseBody List<ServicePatient> getMedicinenum(@PathVariable("reg") String reg) {
		return roomstypeRepo.findMedicinebyregnum(reg);
	}

}
