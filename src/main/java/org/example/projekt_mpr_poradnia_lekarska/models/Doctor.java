package org.example.projekt_mpr_poradnia_lekarska.models;

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
@NoArgsConstructor
@AllArgsConstructor
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
