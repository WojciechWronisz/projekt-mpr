package org.example.projekt.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.projekt.models.Appointment;
import org.example.projekt.models.AppointmentRequest;
import org.example.projekt.models.AppointmentResponse;
import org.example.projekt.workshop.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper; // MapStruct Mapper

    // Pobranie wszystkich wizyt
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointmentMapper::mapToAppointmentResponse) // Mapowanie za pomocą MapStruct
                .toList();
    }

    // Dodanie nowej wizyty
    public AppointmentResponse addAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = appointmentMapper.mapToAppointment(appointmentRequest); // Mapowanie request -> entity
        Appointment savedAppointment = appointmentRepository.save(appointment); // Zapis w bazie danych
        return appointmentMapper.mapToAppointmentResponse(savedAppointment); // Mapowanie entity -> response
    }

    // Usunięcie wizyty
    public void deleteAppointment(UUID id) {
        if (!appointmentRepository.existsById(id)) {
            throw new EntityNotFoundException("Appointment not found with ID: " + id);
        }
        appointmentRepository.deleteById(id);
    }

    // Pobranie wizyty na podstawie ID
    public AppointmentResponse getAppointmentById(UUID id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + id));
        return appointmentMapper.mapToAppointmentResponse(appointment);
    }

    // Aktualizacja wizyty
    public AppointmentResponse updateAppointment(UUID id, AppointmentRequest updatedAppointmentRequest) {
        // Znajdź istniejącą wizytę lub rzuć wyjątek
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + id));

        // Zaktualizuj pola na podstawie wartości z requestu
        existingAppointment.setDateTime(updatedAppointmentRequest.getDateTime());
        existingAppointment.setPatientName(updatedAppointmentRequest.getPatientName());
        existingAppointment.setPatientEmail(updatedAppointmentRequest.getPatientEmail());
        existingAppointment.setReason(updatedAppointmentRequest.getReason());

        // Zapisz zmiany w bazie
        Appointment updatedAppointment = appointmentRepository.save(existingAppointment);

        // Zwróć zaktualizowany obiekt jako response
        return appointmentMapper.mapToAppointmentResponse(updatedAppointment);
    }
}
