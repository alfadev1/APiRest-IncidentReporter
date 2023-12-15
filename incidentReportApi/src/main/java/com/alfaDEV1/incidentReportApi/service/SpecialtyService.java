package com.alfaDEV1.incidentReportApi.service;

import com.alfaDEV1.incidentReportApi.persistence.dao.ISpecialtyDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Specialty;
import com.alfaDEV1.incidentReportApi.service.interfaces.ISpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SpecialtyService implements ISpecialtyService {
    @Autowired
    private ISpecialtyDAO specialtyDAO;
    @Override
    public void saveSpecialty(Specialty specialty) {
        specialtyDAO.saveSpecialty(specialty);
    }

    @Override
    public void deleteSpecialtyById(Long id) {
        specialtyDAO.findSpecialtyById(id);
    }

    @Override
    public Optional<Specialty> findSpecialtyById(Long id) {
        return specialtyDAO.findSpecialtyById(id);
    }

    @Override
    public List<Specialty> findAllSpecialtys() {
        return specialtyDAO.findAllSpecialtys();
    }
}
