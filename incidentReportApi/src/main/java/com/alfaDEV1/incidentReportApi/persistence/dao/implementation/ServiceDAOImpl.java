package com.alfaDEV1.incidentReportApi.persistence.dao.implementation;

import com.alfaDEV1.incidentReportApi.persistence.dao.IServiceDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Service;
import com.alfaDEV1.incidentReportApi.persistence.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceDAOImpl implements IServiceDAO {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public void saveService(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteServiceById(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Optional<Service> findServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<Service> findAllServices() {
        return serviceRepository.findAll();
    }
}
