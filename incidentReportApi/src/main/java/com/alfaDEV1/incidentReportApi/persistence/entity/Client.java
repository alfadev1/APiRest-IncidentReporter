package com.alfaDEV1.incidentReportApi.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int idCliente;
    private String razonSocial;
    private int cuit;

    private List<Service> serviceList = new ArrayList<>();
    private List<Incident> incidentList = new ArrayList<>();
}
