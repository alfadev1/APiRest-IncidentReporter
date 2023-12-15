package com.alfaDEV1.incidentReportApi.service.interfaces;

import com.alfaDEV1.incidentReportApi.persistence.entity.Incident;

import java.util.List;
import java.util.Optional;

public interface IIncidentService {
    void saveIncident(Incident incident);
    void deleteIncidentById(Long id);
    Optional<Incident> findIncidentById(Long id);
    List<Incident> findAllIncidents();
}
