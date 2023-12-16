package com.alfaDEV1.incidentReportApi.controller;

import com.alfaDEV1.incidentReportApi.persistence.dto.IncidentDTO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Incident;
import com.alfaDEV1.incidentReportApi.persistence.entity.State;
import com.alfaDEV1.incidentReportApi.service.interfaces.IIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

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
}
