package com.alfaDEV1.incidentReportApi.persistence.dto;

import com.alfaDEV1.incidentReportApi.persistence.entity.Incident;
import com.alfaDEV1.incidentReportApi.persistence.entity.Specialty;
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

public class IncidentTypeDTO {
    private String name;
    private int estimatedTime;
    private int maximumTime;
    private List<Incident> incidentList= new ArrayList<>();
    private List<Specialty> specialtyList = new ArrayList<>();
}
