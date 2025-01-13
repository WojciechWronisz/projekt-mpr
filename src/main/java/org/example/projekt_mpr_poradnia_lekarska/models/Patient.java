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

@Entity //mapowanie obiektow na tabele
@Getter
@Setter
@NoArgsConstructor //taki getter ale nie musze podawac first name itp
@AllArgsConstructor // jak dostane requesta zeby dodac do bazy danych nowy obiekt
                    // to dizeki temu musze napisac te wszystkie rzeczy
public class Patient {

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "patient") // "patient" musi istnieć w klasie Appointment
    private List<Appointment> appointments;
}
