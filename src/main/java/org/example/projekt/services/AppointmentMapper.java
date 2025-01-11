package org.example.projekt.services;

import org.example.projekt.models.Appointment;
import org.example.projekt.models.AppointmentRequest;
import org.example.projekt.models.AppointmentResponse;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public Appointment mapToAppointment(AppointmentRequest request) {
        Appointment appointment = new Appointment();
        appointment.setDateTime(request.getDateTime());
        appointment.setPatientName(request.getPatientName());
        appointment.setPatientEmail(request.getPatientEmail());
        appointment.setReason(request.getReason());
        return appointment;
    }

//    public AppointmentResponse mapToAppointmentResponse(Appointment updatedAppointment) {
//        return appointment;
//    }

//    public AppointmentResponse mapToAppointmentResponse(Appointment appointment) {
//        return new AppointmentResponse(
//                appointment.getId().toString(),
//                appointment.getDateTime(),
//                appointment.getPatientName(),
//                appointment.getPatientEmail(),
//                appointment.getReason(),
//                appointment.getDoctor().getFirstName() + " " + appointment.getDoctor().getLastName()
//        );
//    }
}
