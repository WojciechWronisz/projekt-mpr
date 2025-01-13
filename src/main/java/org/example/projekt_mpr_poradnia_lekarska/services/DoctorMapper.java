package org.example.projekt_mpr_poradnia_lekarska.services;

import org.example.projekt_mpr_poradnia_lekarska.models.Doctor;
import org.example.projekt_mpr_poradnia_lekarska.models.DoctorRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor mapToDoctor(DoctorRequest request);
}
