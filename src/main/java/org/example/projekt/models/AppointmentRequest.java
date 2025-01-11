package org.example.projekt.models;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private String patientName;
    private String patientEmail;
    private String reason;
    private LocalDateTime dateTime;
    private String doctorId;

    public Appointment toEntity() {
        return Appointment.builder()
                .patientName(patientName)
                .patientEmail(patientEmail)
                .reason(reason)
                .dateTime(dateTime)
                .build();
    }
}
