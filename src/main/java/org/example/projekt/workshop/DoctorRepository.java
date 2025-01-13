package org.example.projekt.workshop;

import org.example.projekt.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

// jpa daje takie rzeczy jak
// save(Doctor doctor) – zapisywanie lub aktualizowanie obiektu.
// findById(UUID id) – znajdowanie rekordu po ID.
// findAll() – pobieranie wszystkich rekordów.
// deleteById(UUID id) – usuwanie rekordu po ID.
// existsById(UUID id) – sprawdzanie, czy rekord istnieje.

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
}
