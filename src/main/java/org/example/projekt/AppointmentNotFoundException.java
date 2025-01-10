package org.example.projekt;

public abstract class AppointmentNotFoundException extends CustomerExpectation {

    public String getMessage() {
        return "AppointmentNotFound";
    }


    public String getCode() {
        return "404"; // Kod błędu HTTP dla "Not Found"
    }


    public String getDescription() {
        return "Nie znaleziono wizyty. Sprawdź poprawność danych i spróbuj ponownie.";
    }
}