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
    private final AppointmentMapper appointmentMapper;

    public List<AppointmentResponse> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(AppointmentResponse::fromEntity)
                .toList();
    }

    public AppointmentResponse addAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = appointmentRequest.toEntity();
        return AppointmentResponse.fromEntity(appointmentRepository.save(appointment));
    }

    public void deleteAppointment(UUID id) {
        appointmentRepository.deleteById(id);
    }

    public AppointmentResponse getAppointmentById(UUID id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + id));
        return appointmentMapper.mapToAppointmentResponse(appointment);
    }

    public AppointmentResponse updateAppointment(UUID id, AppointmentRequest updatedAppointmentRequest) {
        return null;
    }
}
