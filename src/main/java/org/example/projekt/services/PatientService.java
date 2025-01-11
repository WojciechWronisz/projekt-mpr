package org.example.projekt.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.projekt.models.Patient;
import org.example.projekt.models.PatientRequest;
import org.example.projekt.workshop.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper; // MapStruct mapper

    /**
     * Pobiera listę wszystkich pacjentów.
     * @return lista obiektów Patient
     */
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    /**
     * Pobiera pacjenta na podstawie ID.
     * @param id identyfikator pacjenta
     * @return obiekt Patient
     */
    public Patient getPatientById(UUID id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + id));
    }

    /**
     * Dodaje nowego pacjenta.
     * @param patientRequest dane wejściowe pacjenta
     * @return zapisany obiekt Patient
     */
    public Patient addPatient(PatientRequest patientRequest) {
        Patient patient = patientMapper.mapToPatient(patientRequest);
        return patientRepository.save(patient);
    }

    /**
     * Aktualizuje dane pacjenta na podstawie ID.
     * @param id identyfikator pacjenta
     * @param patientRequest dane do aktualizacji
     * @return zaktualizowany obiekt Patient
     */
    public Patient updatePatient(UUID id, PatientRequest patientRequest) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + id));

        // Aktualizacja danych
        existingPatient.setFirstName(patientRequest.getFirstName());
        existingPatient.setLastName(patientRequest.getLastName());
        existingPatient.setEmail(patientRequest.getEmail());
        existingPatient.setPhoneNumber(patientRequest.getPhoneNumber());

        return patientRepository.save(existingPatient);
    }

    /**
     * Usuwa pacjenta na podstawie ID.
     * @param id identyfikator pacjenta
     */
    public void deletePatient(UUID id) {
        if (!patientRepository.existsById(id)) {
            throw new EntityNotFoundException("Patient not found with ID: " + id);
        }
        patientRepository.deleteById(id);
    }
}
