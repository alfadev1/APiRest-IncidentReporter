package com.alfaDEV1.incidentReportApi.persistence.dao.implementation;

import com.alfaDEV1.incidentReportApi.persistence.dao.ITechnicianDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Technician;
import com.alfaDEV1.incidentReportApi.persistence.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class TechnicianDAOImpl implements ITechnicianDAO {
    @Autowired
    private TechnicianRepository technicianRepository;
    @Override
    public void saveTechnician(Technician technician) {
        technicianRepository.save(technician);
    }

    @Override
    public void deleteTechnicianById(Long id) {
        technicianRepository.deleteById(id);
    }

    @Override
    public Optional<Technician> findTechnicianById(Long id) {
        return technicianRepository.findById(id);
    }

    @Override
    public List<Technician> findAllTechnicians() {
        return technicianRepository.findAll();
    }
}
