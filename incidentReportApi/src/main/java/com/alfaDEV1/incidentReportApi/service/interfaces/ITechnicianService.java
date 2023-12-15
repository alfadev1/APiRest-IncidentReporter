package com.alfaDEV1.incidentReportApi.service.interfaces;

import com.alfaDEV1.incidentReportApi.persistence.entity.Technician;

import java.util.List;
import java.util.Optional;

public interface ITechnicianService {
    void saveTechnician(Technician technician);
    void deleteTechnicianById(Long id);
    Optional<Technician> findTechnicianById(Long id);
    List<Technician> findAllTechnicians();
}
