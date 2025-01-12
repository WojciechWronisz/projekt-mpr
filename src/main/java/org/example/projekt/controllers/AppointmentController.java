package org.example.projekt.controllers;

import lombok.RequiredArgsConstructor;
import org.example.projekt.models.AppointmentRequest;
import org.example.projekt.models.AppointmentResponse;
import org.example.projekt.services.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @PostMapping("/appointment")
    public AppointmentResponse addAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        return appointmentService.addAppointment(appointmentRequest);
    }

    @GetMapping("/appointment/{id}")
    public AppointmentResponse getAppointment(@PathVariable UUID id) {
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("/appointment/{id}")
    public AppointmentResponse editAppointment(@PathVariable UUID id, @RequestBody AppointmentRequest updatedAppointmentRequest) {
        return appointmentService.updateAppointment(id, updatedAppointmentRequest);
    }

    @DeleteMapping("/appointment/{id}")
    public void deleteAppointment(@PathVariable UUID id) {
        appointmentService.deleteAppointment(id);
    }
}
