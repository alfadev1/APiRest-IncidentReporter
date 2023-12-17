package com.alfaDEV1.incidentReportApi.controller;


import com.alfaDEV1.incidentReportApi.persistence.dto.IncidentTypeDTO;
import com.alfaDEV1.incidentReportApi.persistence.entity.IncidentType;
import com.alfaDEV1.incidentReportApi.service.interfaces.IIncidentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/incidentTypes")
public class IncidentTypeController {
    @Autowired
    private IIncidentTypeService incidentTypeService;

    @PostMapping("/saveIncidentTypes")
    public ResponseEntity<?> saveIncidentTypes(@RequestBody IncidentTypeDTO incidentTypeDTO) throws URISyntaxException {
        if (incidentTypeDTO.getName().isBlank() || String.valueOf(incidentTypeDTO.getMaximumTime()).isBlank() || String.valueOf(incidentTypeDTO.getEstimatedTime()).isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        incidentTypeService.saveIncidentType(IncidentType.builder()
                .name(incidentTypeDTO.getName())
                .description(incidentTypeDTO.getDescription())
                .maximumTime(incidentTypeDTO.getMaximumTime())
                .estimatedTime(incidentTypeDTO.getEstimatedTime())
                .build());
        return ResponseEntity.created(new URI("/api/incidentTypes")).build();
    }

    @DeleteMapping("/deleteIncidentTypeById/{id}")
    public ResponseEntity<?> deleteIncidentTypeById(@PathVariable Long id) {
        Optional<IncidentType> incidentTypeOptional = incidentTypeService.findIncidentTypeById(id);
        if (incidentTypeOptional.isPresent()) {
            incidentTypeService.deleteIncidentTypeById(id);
            return ResponseEntity.ok("Register Deleted");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findIncidentTypeById/{id}")
    public ResponseEntity<?> findIncidentTypeByID(@PathVariable Long id) {
        Optional<IncidentType> incidentTypeOptional = incidentTypeService.findIncidentTypeById(id);
        if (incidentTypeOptional.isPresent()) {
            IncidentType incidentType = incidentTypeOptional.get();
            IncidentTypeDTO incidentTypeDTO = IncidentTypeDTO.builder()
                    .name(incidentType.getName())
                    .description(incidentType.getDescription())
                    .maximumTime(incidentType.getMaximumTime())
                    .estimatedTime(incidentType.getEstimatedTime())
                    .build();
            return ResponseEntity.ok(incidentTypeDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAllIncidentTypes")
    public ResponseEntity<?> findAllIncidentTypes() {
        List<IncidentTypeDTO> incidentTypeDTOList = incidentTypeService.findAllIncidentTypes()
                .stream()
                .map(incidentType -> IncidentTypeDTO.builder()
                        .name(incidentType.getName())
                        .description(incidentType.getDescription())
                        .maximumTime(incidentType.getMaximumTime())
                        .estimatedTime(incidentType.getEstimatedTime())
                        .build())
                .toList();
        return ResponseEntity.ok(incidentTypeDTOList);
    }
}
