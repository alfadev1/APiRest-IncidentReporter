package com.alfaDEV1.incidentReportApi.service.interfaces;

import com.alfaDEV1.incidentReportApi.persistence.entity.Service;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    void saveService(Service service);
    void deleteServiceById(Long id);
    Optional<Service> findServiceById(Long id);
    List<Service> findAllServices();
}
