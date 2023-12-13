package com.alfaDEV1.incidentReportApi.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private Long id;
    private String companyName;
    private String name;
    private String lastName;
    private int cuit;

    private List<Service> serviceList = new ArrayList<>();
    private List<Incident> incidentList = new ArrayList<>();
}
