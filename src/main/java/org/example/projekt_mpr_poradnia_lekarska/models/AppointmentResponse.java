package org.example.projekt_mpr_poradnia_lekarska.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor

// służy do reprezentowania danych zwracanych do klienta
// (np. frontendu) po przetworzeniu żądania w aplikacji
public class AppointmentResponse {
    private String id; // UUID konwertowany na String
    private LocalDateTime dateTime;
    private String patientName;
    private String patientEmail;
    private String reason;
    private String doctorFirstName;
    private String doctorLastName;
}
