package com.alfaDEV1.incidentReportApi.controller;

import com.alfaDEV1.incidentReportApi.persistence.dto.TechnicianDTO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Technician;
import com.alfaDEV1.incidentReportApi.service.interfaces.ITechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/technicians")

public class TechnicianController {
    @Autowired
    private ITechnicianService technicianService;

    @PostMapping("/saveTechnician")
    public ResponseEntity<?> saveTechnician(@RequestBody TechnicianDTO technicianDTO) throws URISyntaxException {
        if(technicianDTO.getName().isBlank() || technicianDTO.getLastName().isBlank() || technicianDTO.getSpecialty() == null || technicianDTO.getEmail().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        technicianService.saveTechnician(Technician.builder()
                .name(technicianDTO.getName())
                .lastName(technicianDTO.getLastName())
                .email(technicianDTO.getEmail())
                .specialty(technicianDTO.getSpecialty())
                .build());
        return ResponseEntity.created(new URI("/api/technicians/saveTechnician")).build();
    }

    @DeleteMapping("/deleteTechnicianById/{id}")
    public ResponseEntity<?> deleteTechnicianById(@PathVariable Long id) {
        Optional<Technician> technicianOptional = technicianService.findTechnicianById(id);
        if (technicianOptional.isPresent()) {
            technicianService.deleteTechnicianById(id);
            return ResponseEntity.ok("Register deleted");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findTechnicianById/{id}")
    public ResponseEntity<?> findTechnicianById(@PathVariable Long id) {
        Optional<Technician> technicianOptional = technicianService.findTechnicianById(id);
        if (technicianOptional.isPresent()) {
            Technician technician = technicianOptional.get();
            TechnicianDTO technicianDTO = TechnicianDTO.builder()
                    .name(technician.getName())
                    .lastName(technician.getLastName())
                    .email(technician.getEmail())
                    .specialty(technician.getSpecialty())
                    .build();
            return ResponseEntity.ok(technicianDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findAllTechnicians")
    public ResponseEntity<?> findAllTechnicians() {
        List<TechnicianDTO> technicianDTOList = technicianService.findAllTechnicians()
                .stream()
                .map(technician -> TechnicianDTO.builder()
                        .name(technician.getName())
                        .lastName(technician.getLastName())
                        .email(technician.getEmail())
                        .specialty(technician.getSpecialty())
                        .build())
                .toList();
        return ResponseEntity.ok(technicianDTOList);
    }
}
