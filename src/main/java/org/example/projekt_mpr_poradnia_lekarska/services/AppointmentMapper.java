package org.example.projekt_mpr_poradnia_lekarska.services;

import org.example.projekt_mpr_poradnia_lekarska.models.Appointment;
import org.example.projekt_mpr_poradnia_lekarska.models.AppointmentRequest;
import org.example.projekt_mpr_poradnia_lekarska.models.AppointmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//Mapowanie służy do konwersji danych między różnymi warstwami aplikacji,
// np. z DTO (Data Transfer Object) do encji bazy danych.

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    // Mapowanie AppointmentRequest -> Appointment
    @Mapping(target = "id", ignore = true) // ID generowane automatycznie
    Appointment mapToAppointment(AppointmentRequest request);

    // Mapowanie Appointment -> AppointmentResponse
    @Mapping(source = "id", target = "id") // Mapowanie ID
    @Mapping(source = "doctor.firstName", target = "doctorFirstName")
    @Mapping(source = "doctor.lastName", target = "doctorLastName")
    AppointmentResponse mapToAppointmentResponse(Appointment appointment);
}
