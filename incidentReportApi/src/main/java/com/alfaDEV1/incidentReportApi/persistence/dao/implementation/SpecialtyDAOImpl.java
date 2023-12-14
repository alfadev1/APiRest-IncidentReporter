package com.alfaDEV1.incidentReportApi.persistence.dao.implementation;

import com.alfaDEV1.incidentReportApi.persistence.dao.ISpecialtyDAO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Specialty;
import com.alfaDEV1.incidentReportApi.persistence.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class SpecialtyDAOImpl implements ISpecialtyDAO {
    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Override
    public void saveSpecialty(Specialty specialty) {
        specialtyRepository.save(specialty);
    }

    @Override
    public void deleteSpecialtyById(Long id) {
        specialtyRepository.deleteById(id);
    }

    @Override
    public Optional<Specialty> findSpecialtyById(Long id) {
        return specialtyRepository.findById(id);
    }

    @Override
    public List<Specialty> findAllSpecialtys() {
        return specialtyRepository.findAll();
    }
}
