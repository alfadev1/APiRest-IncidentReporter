package com.alfaDEV1.incidentReportApi.persistence.dao.implementation;

import com.alfaDEV1.incidentReportApi.persistence.dao.IIncidentTypeDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.IncidentType;
import com.alfaDEV1.incidentReportApi.persistence.repository.IncidentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IncidentTypeDAOImpl implements IIncidentTypeDAO {
    @Autowired
    private IncidentTypeRepository incidentTypeRepository;

    @Override
    public void saveIncidentType(IncidentType incidentType) {
        incidentTypeRepository.save(incidentType);
    }

    @Override
    public void deleteIncidentTypeById(Long id) {
        incidentTypeRepository.deleteById(id);
    }

    @Override
    public Optional<IncidentType> findIncidentTypeById(Long id) {
        return incidentTypeRepository.findById(id);
    }

    @Override
    public List<IncidentType> findAllIncidentTypes() {
        return incidentTypeRepository.findAll();
    }
}
