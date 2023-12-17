package com.alfaDEV1.incidentReportApi.controller;

import com.alfaDEV1.incidentReportApi.persistence.dto.SpecialtyDTO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Specialty;
import com.alfaDEV1.incidentReportApi.service.interfaces.ISpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/specialtys")

public class SpecialtyController {

    @Autowired
    private ISpecialtyService specialtyService;

    @PostMapping("/saveSpecialty")
    public ResponseEntity<?> saveSpecialty(@RequestBody SpecialtyDTO specialtyDTO) throws URISyntaxException {
        if(specialtyDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        specialtyService.saveSpecialty(Specialty.builder()
                .name(specialtyDTO.getName())
                .build());
        return ResponseEntity.created(new URI("/api/specialtys/saveSpecialty")).build();
    }

    @DeleteMapping("/deleteSpecialtyById/{id}")
    public ResponseEntity<?> deleteSpecialtyById(@PathVariable Long id) {
        Optional<Specialty> specialtyOptional = specialtyService.findSpecialtyById(id);
        if (specialtyOptional.isPresent()) {
            specialtyService.deleteSpecialtyById(id);
            return ResponseEntity.ok("Register deleted");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findSpecialtyById/{id}")
    public ResponseEntity<?> findSpecialtyById(@PathVariable Long id) {
        Optional<Specialty> specialtyOptional = specialtyService.findSpecialtyById(id);
        if (specialtyOptional.isPresent()) {
            Specialty specialty = specialtyOptional.get();
            SpecialtyDTO specialtyDTO = SpecialtyDTO.builder()
                    .name(specialty.getName())
                    .build();
            return ResponseEntity.ok(specialtyDTO);
        }
        return  ResponseEntity.notFound().build();
    }

    @GetMapping("/findAllSpecialtys")
    public ResponseEntity<?> findAllSpecialtys() {
        List<SpecialtyDTO> specialtyDTOList = specialtyService.findAllSpecialtys()
                .stream()
                .map(specialty -> SpecialtyDTO.builder()
                        .name(specialty.getName())
                        .build())
                .toList();
        return ResponseEntity.ok(specialtyDTOList);
    }
}
