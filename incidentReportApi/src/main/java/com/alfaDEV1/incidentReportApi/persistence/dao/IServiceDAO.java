package com.alfaDEV1.incidentReportApi.persistence.dao;

import com.alfaDEV1.incidentReportApi.persistence.entity.Service;

import java.util.List;
import java.util.Optional;

public interface IServiceDAO {
    void saveService(Service service);
    void deleteServiceById(Long id);
    Optional<Service> findServiceById(Long id);
    List<Service> findAllServices();
}
