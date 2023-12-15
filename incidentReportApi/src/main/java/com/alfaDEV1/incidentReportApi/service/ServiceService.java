package com.alfaDEV1.incidentReportApi.service;

import com.alfaDEV1.incidentReportApi.persistence.dao.IServiceDAO;
import com.alfaDEV1.incidentReportApi.service.interfaces.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ServiceService implements IServiceService {
    @Autowired
    private IServiceDAO serviceDAO;

    @Override
    public void saveService(com.alfaDEV1.incidentReportApi.persistence.entity.Service service) {
        serviceDAO.saveService(service);
    }

    @Override
    public void deleteServiceById(Long id) {
        serviceDAO.deleteServiceById(id);
    }

    @Override
    public Optional<com.alfaDEV1.incidentReportApi.persistence.entity.Service> findServiceById(Long id) {
        return serviceDAO.findServiceById(id);
    }

    @Override
    public List<com.alfaDEV1.incidentReportApi.persistence.entity.Service> findAllServices() {
        return serviceDAO.findAllServices();
    }
}
