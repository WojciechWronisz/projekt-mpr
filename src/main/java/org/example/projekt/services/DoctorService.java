package org.example.projekt.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.projekt.models.Doctor;
import org.example.projekt.models.DoctorRequest;
import org.example.projekt.workshop.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper; // MapStruct mapper

    /**
     * Pobiera listę wszystkich lekarzy.
     * @return lista obiektów Doctor
     */
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    /**
     * Pobiera lekarza na podstawie ID.
     * @param id identyfikator lekarza
     * @return obiekt Doctor
     */
    public Doctor getDoctorById(UUID id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + id));
    }

    /**
     * Dodaje nowego lekarza.
     * @param doctorRequest dane wejściowe lekarza
     * @return zapisany obiekt Doctor
     */
    public Doctor addDoctor(DoctorRequest doctorRequest) {
        Doctor doctor = doctorMapper.mapToDoctor(doctorRequest);
        return doctorRepository.save(doctor);
    }

    /**
     * Aktualizuje dane lekarza na podstawie ID.
     * @param id identyfikator lekarza
     * @param doctorRequest dane do aktualizacji
     * @return zaktualizowany obiekt Doctor
     */
    public Doctor updateDoctor(UUID id, DoctorRequest doctorRequest) {
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + id));

        // Aktualizacja danych
        existingDoctor.setFirstName(doctorRequest.getFirstName());
        existingDoctor.setLastName(doctorRequest.getLastName());
        existingDoctor.setSpecialization(doctorRequest.getSpecialization());
        existingDoctor.setEmail(doctorRequest.getEmail());
        existingDoctor.setPhoneNumber(doctorRequest.getPhoneNumber());

        return doctorRepository.save(existingDoctor);
    }

    /**
     * Usuwa lekarza na podstawie ID.
     * @param id identyfikator lekarza
     */
    public void deleteDoctor(UUID id) {
        if (!doctorRepository.existsById(id)) {
            throw new EntityNotFoundException("Doctor not found with ID: " + id);
        }
        doctorRepository.deleteById(id);
    }
}
