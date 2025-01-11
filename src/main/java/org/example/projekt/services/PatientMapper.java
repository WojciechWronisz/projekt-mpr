package org.example.projekt.services;

import org.example.projekt.models.Patient;
import org.example.projekt.models.PatientRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient mapToPatient(PatientRequest request);
}
