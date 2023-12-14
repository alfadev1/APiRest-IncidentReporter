package com.alfaDEV1.incidentReportApi.persistence.dto;

import com.alfaDEV1.incidentReportApi.persistence.entity.Client;
import com.alfaDEV1.incidentReportApi.persistence.entity.Incident;
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

public class ServiceDTO {
    private String name;
    private String description;
    private List<Incident> incidentList = new ArrayList<>();
    private List<Client> clientList = new ArrayList<>();
}
