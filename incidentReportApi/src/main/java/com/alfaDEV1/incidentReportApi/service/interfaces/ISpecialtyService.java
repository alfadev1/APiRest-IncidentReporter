package com.alfaDEV1.incidentReportApi.service.interfaces;

import com.alfaDEV1.incidentReportApi.persistence.entity.Specialty;

import java.util.List;
import java.util.Optional;

public interface ISpecialtyService {
    void saveSpecialty(Specialty specialty);
    void deleteSpecialtyById(Long id);
    Optional<Specialty> findSpecialtyById(Long id);
    List<Specialty> findAllSpecialtys();
}
