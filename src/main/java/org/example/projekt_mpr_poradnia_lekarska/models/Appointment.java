package org.example.projekt_mpr_poradnia_lekarska.models;

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
@Table(name = "appointments") // Nazwa tabeli w bazie danych
public class Appointment {


    //na sile wstawione Derived Query Methods chodzi o to ze
    // Spring sam wygeneruje odpowiedni kod SQL do wyszukiwania danych.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Automatyczne generowanie UUID
    private UUID id;

    @Column(nullable = false) // Data i czas wizyty są wymagane
    private LocalDateTime dateTime;

    @Column(nullable = false) // Imię i nazwisko pacjenta są wymagane
    private String patientName;

    @Column(nullable = false) // Email pacjenta jest wymagany
    private String patientEmail;

    @Column(length = 500) // Powód wizyty z maksymalną długością 500 znaków
    private String reason;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false) // Klucz obcy do tabeli lekarzy
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id") // Klucz obcy do tabeli pacjentów (może być null)
    private Patient patient;
}
