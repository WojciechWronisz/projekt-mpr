package org.example.projekt.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.print.Doc;
import java.time.LocalDateTime;

@Getter
@Builder
@Setter
public class AppointmentResponse {
    private String id;
    private LocalDateTime dateTime;
    private String patientName;
    private String patientEmail;
    private String reason;
    private Doctor doctorName;

    public static AppointmentResponse fromEntity(Appointment appointment) {
        return AppointmentResponse.builder()
                .id(appointment.getId().toString())
                .dateTime(appointment.getDateTime())
                .patientName(appointment.getPatientName())
                .patientEmail(appointment.getPatientEmail())
                .reason(appointment.getReason())
                .doctorName(appointment.getDoctor())
                .build();
    }
}
