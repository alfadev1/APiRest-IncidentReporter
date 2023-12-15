package com.alfaDEV1.incidentReportApi.service;

import com.alfaDEV1.incidentReportApi.persistence.dao.IIncidentDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Incident;
import com.alfaDEV1.incidentReportApi.service.interfaces.IIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class IncidentService implements IIncidentService {
    @Autowired
    private IIncidentDAO incidentDAO;

    @Override
    public void saveIncident(Incident incident) {
        incidentDAO.saveIncident(incident);
    }

    @Override
    public void deleteIncidentById(Long id) {
        incidentDAO.deleteIncidentById(id);
    }

    @Override
    public Optional<Incident> findIncidentById(Long id) {
        return incidentDAO.findIncidentById(id);
    }

    @Override
    public List<Incident> findAllIncidents() {
        return incidentDAO.findAllIncidents();
    }
}
