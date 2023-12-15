package com.alfaDEV1.incidentReportApi.service;

import com.alfaDEV1.incidentReportApi.persistence.dao.IIncidentTypeDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.IncidentType;
import com.alfaDEV1.incidentReportApi.service.interfaces.IIncidentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class IncidentTypeService implements IIncidentTypeService {
    @Autowired
    private IIncidentTypeDAO incidentTypeDAO;
    @Override
    public void saveIncidentType(IncidentType incidentType) {
        incidentTypeDAO.saveIncidentType(incidentType);
    }

    @Override
    public void deleteIncidentTypeById(Long id) {
        incidentTypeDAO.deleteIncidentTypeById(id);
    }

    @Override
    public Optional<IncidentType> findIncidentTypeById(Long id) {
        return incidentTypeDAO.findIncidentTypeById(id);
    }

    @Override
    public List<IncidentType> findAllIncidentTypes() {
        return incidentTypeDAO.findAllIncidentTypes();
    }
}
