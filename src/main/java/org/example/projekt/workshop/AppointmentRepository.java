package org.example.projekt.workshop;

import org.example.projekt.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findAllByDoctorId(UUID doctorId);
    List<Appointment> findAllByDateTimeBetween(LocalDateTime start, LocalDateTime end);

}
