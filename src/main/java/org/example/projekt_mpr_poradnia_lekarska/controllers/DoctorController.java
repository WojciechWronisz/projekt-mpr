package org.example.projekt_mpr_poradnia_lekarska.controllers;

import lombok.RequiredArgsConstructor;
import org.example.projekt_mpr_poradnia_lekarska.models.Doctor;
import org.example.projekt_mpr_poradnia_lekarska.models.DoctorRequest;
import org.example.projekt_mpr_poradnia_lekarska.services.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable UUID id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody DoctorRequest doctorRequest) {
        return ResponseEntity.ok(doctorService.addDoctor(doctorRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable UUID id, @RequestBody DoctorRequest doctorRequest) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctorRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable UUID id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
