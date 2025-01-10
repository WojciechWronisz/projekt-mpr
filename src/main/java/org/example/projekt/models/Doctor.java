package org.example.projekt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
