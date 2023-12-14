package com.alfaDEV1.incidentReportApi.persistence.dao;

import com.alfaDEV1.incidentReportApi.persistence.entity.Operator;

import java.util.List;
import java.util.Optional;

public interface IOperatorDAO {
    void saveOperator(Operator operator);
    void deleteOperatorById(Long id);
    Optional<Operator> findOperatorById(Long id);
    List<Operator> findAllOperators();
}
