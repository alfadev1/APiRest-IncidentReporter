package com.alfaDEV1.incidentReportApi.persistence.entity;





import java.time.LocalDateTime;

public class Incident {
    private int id;
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

}
