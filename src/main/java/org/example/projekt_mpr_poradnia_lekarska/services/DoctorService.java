package org.example.projekt_mpr_poradnia_lekarska.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.projekt_mpr_poradnia_lekarska.models.Doctor;
import org.example.projekt_mpr_poradnia_lekarska.models.DoctorRequest;
import org.example.projekt_mpr_poradnia_lekarska.workshop.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Getter
@Setter

public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper; // MapStruct mapper

//
//      Pobiera listę wszystkich lekarzy.
//      @return lista obiektów Doctor
//
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

//
//      Pobiera lekarza na podstawie ID.
//      @param id identyfikator lekarza
//      @return obiekt Doctor
//

    public Doctor getDoctorById(UUID id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + id));
    }

//
//      Dodaje nowego lekarza.
//      @param doctorRequest dane wejściowe lekarza
//      @return zapisany obiekt Doctor
//
    public Doctor addDoctor(DoctorRequest doctorRequest) {
        Doctor doctor = doctorMapper.mapToDoctor(doctorRequest);
        return doctorRepository.save(doctor);
    }

//
//      Aktualizuje dane lekarza na podstawie ID.
//      @param id identyfikator lekarza
//      @param doctorRequest dane do aktualizacji
//      @return zaktualizowany obiekt Doctor
//
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

//
//      Usuwa lekarza na podstawie ID.
//      @param id identyfikator lekarza
//

    public void deleteDoctor(UUID id) {
        if (!doctorRepository.existsById(id)) {
            throw new EntityNotFoundException("Doctor not found with ID: " + id);
        }
        doctorRepository.deleteById(id);
    }
}
