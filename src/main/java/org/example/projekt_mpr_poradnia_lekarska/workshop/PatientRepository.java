package org.example.projekt_mpr_poradnia_lekarska.workshop;

import org.example.projekt_mpr_poradnia_lekarska.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
