package com.alfaDEV1.incidentReportApi.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private Long id;
    private String name;
    private String description;
    private List<Client> clientList = new ArrayList<>();
    private List<Incident> incidentList = new ArrayList<>();

}
