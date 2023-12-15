package com.alfaDEV1.incidentReportApi.service.interfaces;

import com.alfaDEV1.incidentReportApi.persistence.entity.IncidentType;

import java.util.List;
import java.util.Optional;

public interface IIncidentTypeService {
    void saveIncidentType(IncidentType incidentType);
    void deleteIncidentTypeById(Long id);
    Optional<IncidentType> findIncidentTypeById(Long id);
    List<IncidentType> findAllIncidentTypes();

}
