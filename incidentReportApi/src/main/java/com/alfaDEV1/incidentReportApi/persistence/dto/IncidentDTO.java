package com.alfaDEV1.incidentReportApi.persistence.dto;

import com.alfaDEV1.incidentReportApi.persistence.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class IncidentDTO {
    private String name;
    private String description;
    private LocalDateTime reportDate;
    private LocalDateTime estimatedResolutionDate;
    private LocalDateTime resolutionDate;
    private State state;
    private boolean colchonHoras;
    private Service service;
    private Client client;
    private Technician technician;
    private Operator operator;
    private IncidentType incidentType;
}
