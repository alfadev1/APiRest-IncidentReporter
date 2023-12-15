package com.alfaDEV1.incidentReportApi.controller;

import com.alfaDEV1.incidentReportApi.persistence.dto.IncidentDTO;
import com.alfaDEV1.incidentReportApi.service.interfaces.IIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/incidents")

public class IncidentController {
    /*@Autowired
    private IIncidentService incidentService;
    @PostMapping("/saveIncident")
    public ResponseEntity<?> saveIncident(@RequestBody IncidentDTO incidentDTO) {

    }*/
}
