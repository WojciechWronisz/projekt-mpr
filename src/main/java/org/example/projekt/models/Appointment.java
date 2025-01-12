package org.example.projekt.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Automatyczne generowanie UUID
    private UUID id;

    private LocalDateTime dateTime;
    private String patientName;
    private String patientEmail;
    private String reason;

    @ManyToOne
    private Doctor doctor; // Relacja z klasą Doctor

    @ManyToOne
    private Patient patient; // Relacja z klasą Patient
}
