package com.alfaDEV1.incidentReportApi.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class Operator {
    private Long id;
    private String name;
    private List<Incident> incidentlist = new ArrayList<>();

}
