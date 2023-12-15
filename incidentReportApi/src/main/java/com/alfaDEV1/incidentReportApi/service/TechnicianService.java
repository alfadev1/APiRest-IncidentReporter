package com.alfaDEV1.incidentReportApi.service;

import com.alfaDEV1.incidentReportApi.persistence.dao.ITechnicianDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Technician;
import com.alfaDEV1.incidentReportApi.service.interfaces.ITechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TechnicianService implements ITechnicianService {
    @Autowired
    private ITechnicianDAO technicianDAO;
    @Override
    public void saveTechnician(Technician technician) {
        technicianDAO.saveTechnician(technician);
    }

    @Override
    public void deleteTechnicianById(Long id) {
        technicianDAO.deleteTechnicianById(id);
    }

    @Override
    public Optional<Technician> findTechnicianById(Long id) {
        return technicianDAO.findTechnicianById(id);
    }

    @Override
    public List<Technician> findAllTechnicians() {
        return technicianDAO.findAllTechnicians();
    }
}
