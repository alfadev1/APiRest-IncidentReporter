package com.alfaDEV1.incidentReportApi.persistence.dao;

import com.alfaDEV1.incidentReportApi.persistence.entity.Specialty;

import java.util.List;
import java.util.Optional;

public interface ISpecialtyDAO {
    void saveSpecialty(Specialty specialty);
    void deleteSpecialtyById(Long id);
    Optional<Specialty> findSpecialtyById(Long id);
    List<Specialty> findAllSpecialtys();
}
