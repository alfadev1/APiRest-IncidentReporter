package com.alfaDEV1.incidentReportApi.persistence.dto;

import com.alfaDEV1.incidentReportApi.persistence.entity.Incident;
import com.alfaDEV1.incidentReportApi.persistence.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClientDTO {
    private String companyName;
    private String name;
    private String lastName;
    private int cuit;
    private List<Incident> incidentList = new ArrayList<>();
    private List<Service> serviceList = new ArrayList<>();
}
