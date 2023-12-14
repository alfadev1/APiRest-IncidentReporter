package com.alfaDEV1.incidentReportApi.persistence.dao;

import com.alfaDEV1.incidentReportApi.persistence.entity.Incident;

import java.util.List;
import java.util.Optional;

public interface IIncidentDAO {
    void saveIncident(Incident incident);
    void deleteIncidentById(Long id);
    Optional<Incident> findIncidentById(Long id);
    List<Incident> findAllIncidents();

}
