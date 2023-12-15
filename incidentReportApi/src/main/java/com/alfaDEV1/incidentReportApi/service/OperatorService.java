package com.alfaDEV1.incidentReportApi.service;

import com.alfaDEV1.incidentReportApi.persistence.dao.IOperatorDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Operator;
import com.alfaDEV1.incidentReportApi.service.interfaces.IOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class OperatorService implements IOperatorService {
    @Autowired
    private IOperatorDAO operatorDAO;
    @Override
    public void saveOperator(Operator operator) {
        operatorDAO.saveOperator(operator);
    }

    @Override
    public void deleteOperatorById(Long id) {
        operatorDAO.deleteOperatorById(id);
    }

    @Override
    public Optional<Operator> findOperatorById(Long id) {
        return operatorDAO.findOperatorById(id);
    }

    @Override
    public List<Operator> findAllOperators() {
        return operatorDAO.findAllOperators();
    }
}
