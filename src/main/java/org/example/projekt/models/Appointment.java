package org.example.projekt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @UuidGenerator
    private UUID id;

    private LocalDateTime dateTime;
    private String patientName;
    private String patientEmail;
    private String reason;

    @ManyToOne
    private Doctor doctor; // Relacja z lekarzem
}
