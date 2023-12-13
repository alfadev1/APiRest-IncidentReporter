package com.alfaDEV1.incidentReportApi.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class Specialty {
    private Long id;
    private String name;
    private List<Technician> techniciansList = new ArrayList<>();
    private List<IncidentType> incidentTypeList = new ArrayList<>();
}
