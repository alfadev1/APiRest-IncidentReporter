package com.alfaDEV1.incidentReportApi.persistence.dao.implementation;

import com.alfaDEV1.incidentReportApi.persistence.dao.IOperatorDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Operator;
import com.alfaDEV1.incidentReportApi.persistence.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OperatorDAOImpl implements IOperatorDAO {
    @Autowired
    private OperatorRepository operatorRepository;
    @Override
    public void saveOperator(Operator operator) {
        operatorRepository.save(operator);
    }

    @Override
    public void deleteOperatorById(Long id) {
        operatorRepository.deleteById(id);
    }

    @Override
    public Optional<Operator> findOperatorById(Long id) {
        return operatorRepository.findById(id);
    }

    @Override
    public List<Operator> findAllOperators() {
        return operatorRepository.findAll();
    }
}
