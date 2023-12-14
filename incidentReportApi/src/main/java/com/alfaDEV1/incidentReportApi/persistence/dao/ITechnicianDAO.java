package com.alfaDEV1.incidentReportApi.persistence.dao;

import com.alfaDEV1.incidentReportApi.persistence.entity.Technician;

import java.util.List;
import java.util.Optional;

public interface ITechnicianDAO {
    void saveTechnician(Technician technician);
    void deleteTechnicianById(Long id);
    Optional<Technician> findTechnicianById(Long id);
    List<Technician> findAllTechnicians();
}
