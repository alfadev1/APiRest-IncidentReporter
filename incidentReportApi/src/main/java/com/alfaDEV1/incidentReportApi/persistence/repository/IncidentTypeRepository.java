package com.alfaDEV1.incidentReportApi.persistence.repository;

import com.alfaDEV1.incidentReportApi.persistence.entity.IncidentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IncidentTypeRepository extends JpaRepository<IncidentType, Long> {
}
