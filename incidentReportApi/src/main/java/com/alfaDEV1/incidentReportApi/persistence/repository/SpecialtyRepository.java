package com.alfaDEV1.incidentReportApi.persistence.repository;

import com.alfaDEV1.incidentReportApi.persistence.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
