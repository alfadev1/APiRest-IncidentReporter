package com.alfaDEV1.incidentReportApi.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table

public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIncident")
    private Long id;
    private String name;
    private String description;
    private LocalDateTime reportDate;
    private LocalDateTime estimatedResolutionDate;
    private LocalDateTime resolutionDate;
    @Enumerated(EnumType.STRING)
    private State state;
    private boolean colchonHoras;
    @ManyToOne
    @JoinColumn(name = "idService")
    private Service service;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "idTechnician")
    private Technician technician;
    @ManyToOne
    @JoinColumn(name = "idOperator")
    private Operator operator;
    @ManyToOne
    @JoinColumn(name = "idIncidentType")
    private IncidentType incidentType;

}
