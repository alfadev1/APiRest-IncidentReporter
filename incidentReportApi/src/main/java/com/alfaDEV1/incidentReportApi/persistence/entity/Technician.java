package com.alfaDEV1.incidentReportApi.persistence.entity;

import java.util.List;

public class Technician {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Specialty specialty;
    private List<Incident> incidentsList;


}
