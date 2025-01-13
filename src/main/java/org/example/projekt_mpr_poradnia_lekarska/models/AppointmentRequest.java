package org.example.projekt_mpr_poradnia_lekarska.models;

import lombok.*;


import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
// Służy do reprezentowania danych przesyłanych od klienta
// podczas tworzenia lub aktualizacji wizyty w aplikacji.
// jest to Data Transfe Object,
public class AppointmentRequest {
    private String patientName;
    private String patientEmail;
    private String reason;
    private LocalDateTime dateTime;
    private String doctorId;

}
