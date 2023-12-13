package com.alfaDEV1.incidentReportApi.persistence.entity;


import java.util.ArrayList;
import java.util.List;

public class IncidentType {
    private Long id;
    private String name;
    private int estimatedTime;
    private int maximumTime;
    private List<Specialty> specialtyList = new ArrayList<>();
    private List<Incident> incidentList= new ArrayList<>();
}
