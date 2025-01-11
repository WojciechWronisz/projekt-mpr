package org.example.projekt.services;

import org.example.projekt.models.Appointment;
import org.example.projekt.models.AppointmentRequest;
import org.example.projekt.models.AppointmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    // Mapowanie AppointmentRequest -> Appointment
    @Mapping(target = "id", ignore = true) // ID generowane automatycznie
    Appointment mapToAppointment(AppointmentRequest request);

    // Mapowanie Appointment -> AppointmentResponse
    @Mapping(source = "doctor.firstName", target = "doctorFirstName")
    @Mapping(source = "doctor.lastName", target = "doctorLastName")
    AppointmentResponse mapToAppointmentResponse(Appointment appointment);
}
