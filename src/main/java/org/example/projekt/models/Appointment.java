package org.example.projekt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @UuidGenerator
    private UUID id;

    private LocalDateTime dateTime;
    private String patientName;
    private String patientEmail;
    private String reason;

    @ManyToOne
    private Doctor doctor;
}
