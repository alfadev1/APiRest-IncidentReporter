package com.alfaDEV1.incidentReportApi.persistence.repository;

import com.alfaDEV1.incidentReportApi.persistence.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OperatorRepository extends JpaRepository<Operator, Long> {
}
