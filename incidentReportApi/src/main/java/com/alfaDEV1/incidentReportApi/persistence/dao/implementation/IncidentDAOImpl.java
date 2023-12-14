package com.alfaDEV1.incidentReportApi.persistence.dao.implementation;

import com.alfaDEV1.incidentReportApi.persistence.dao.IIncidentDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Incident;
import com.alfaDEV1.incidentReportApi.persistence.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IncidentDAOImpl implements IIncidentDAO {
    @Autowired
    private IncidentRepository incidentRepository;
    @Override
    public void saveIncident(Incident incident) {
        incidentRepository.save(incident);
    }

    @Override
    public void deleteIncidentById(Long id) {
        incidentRepository.deleteById(id);
    }

    @Override
    public Optional<Incident> findIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    @Override
    public List<Incident> findAllIncidents() {
        return incidentRepository.findAll();
    }
}
