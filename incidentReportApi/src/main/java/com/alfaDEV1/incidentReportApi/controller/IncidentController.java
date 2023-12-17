package com.alfaDEV1.incidentReportApi.controller;

import com.alfaDEV1.incidentReportApi.persistence.dto.IncidentDTO;

import com.alfaDEV1.incidentReportApi.persistence.entity.Incident;
import com.alfaDEV1.incidentReportApi.persistence.entity.State;
import com.alfaDEV1.incidentReportApi.service.interfaces.IIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/incidents")

public class IncidentController {
    @Autowired
    private IIncidentService incidentService;
    @PostMapping("/saveIncident")
    public ResponseEntity<?> saveIncident(@RequestBody IncidentDTO incidentDTO) throws URISyntaxException {
        if (incidentDTO.getName().isBlank() || incidentDTO.getDescription().isBlank() || incidentDTO.getOperator().getId().toString().isBlank() || incidentDTO.getClient() == null || incidentDTO.getIncidentType() == null || incidentDTO.getService() == null) {
            return ResponseEntity.badRequest().build();
        }
        incidentService.saveIncident(Incident.builder()
                .name(incidentDTO.getName())
                .operator(incidentDTO.getOperator())
                .description(incidentDTO.getDescription())
                .client(incidentDTO.getClient())
                .incidentType(incidentDTO.getIncidentType())
                .reportDate(LocalDateTime.now())
                .service(incidentDTO.getService())
                .technician(null)
                .state(State.IN_PROCESS)
                .estimatedResolutionDate(LocalDateTime.now().plusHours(incidentDTO.getIncidentType().getEstimatedTime()))
                .build());
            return ResponseEntity.created(new URI("/api/incidents/saveIncident")).build();
    }

    @DeleteMapping("/deleteIncidentById/{id}")
    public ResponseEntity<?> deleteIncidentById(@PathVariable Long id) {
        Optional<Incident> incidentOptional = incidentService.findIncidentById(id);
        if (incidentOptional.isPresent()) {
            incidentService.deleteIncidentById(id);
            return ResponseEntity.ok("Register deleted");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findIncidentById/{id}")
    public ResponseEntity<?> findClientById(@PathVariable Long id) {
        Optional<Incident> incidentOptional = incidentService.findIncidentById(id);
        if (incidentOptional.isPresent()) {
            Incident incident = incidentOptional.get();
            IncidentDTO incidentDTO = IncidentDTO.builder()
                    .name(incident.getName())
                    .description(incident.getDescription())
                    .reportDate(incident.getReportDate())
                    .estimatedResolutionDate(incident.getEstimatedResolutionDate())
                    .resolutionDate(incident.getResolutionDate())
                    .state(incident.getState())
                    .colchonHoras(incident.isColchonHoras())
                    .service(incident.getService())
                    .client(incident.getClient())
                    .technician(incident.getTechnician())
                    .operator(incident.getOperator())
                    .incidentType(incident.getIncidentType())
                    .build();
            return ResponseEntity.ok(incidentDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAllIncidents")
    public ResponseEntity<?> findAllIncident() {
        List<IncidentDTO> incidentDTOList = incidentService.findAllIncidents()
                .stream()
                .map(incident -> IncidentDTO.builder()
                        .name(incident.getName())
                        .description(incident.getDescription())
                        .reportDate(incident.getReportDate())
                        .estimatedResolutionDate(incident.getEstimatedResolutionDate())
                        .resolutionDate(incident.getResolutionDate())
                        .state(incident.getState())
                        .colchonHoras(incident.isColchonHoras())
                        .service(incident.getService())
                        .client(incident.getClient())
                        .technician(incident.getTechnician())
                        .operator(incident.getOperator())
                        .incidentType(incident.getIncidentType())
                        .build())
                .toList();
        return ResponseEntity.ok(incidentDTOList);
    }
}
