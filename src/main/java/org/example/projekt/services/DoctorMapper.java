package org.example.projekt.services;

import org.example.projekt.models.Doctor;
import org.example.projekt.models.DoctorRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor mapToDoctor(DoctorRequest request);
}
