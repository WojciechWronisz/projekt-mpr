package org.example.projekt_mpr_poradnia_lekarska.controllers;

import lombok.RequiredArgsConstructor;
import org.example.projekt_mpr_poradnia_lekarska.models.Patient;
import org.example.projekt_mpr_poradnia_lekarska.models.PatientRequest;
import org.example.projekt_mpr_poradnia_lekarska.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable UUID id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody PatientRequest patientRequest) {
        return ResponseEntity.ok(patientService.addPatient(patientRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable UUID id, @RequestBody PatientRequest patientRequest) {
        return ResponseEntity.ok(patientService.updatePatient(id, patientRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
