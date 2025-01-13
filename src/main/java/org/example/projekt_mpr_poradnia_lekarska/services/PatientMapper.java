package org.example.projekt_mpr_poradnia_lekarska.services;

import org.example.projekt_mpr_poradnia_lekarska.models.Patient;
import org.example.projekt_mpr_poradnia_lekarska.models.PatientRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient mapToPatient(PatientRequest request);
}
