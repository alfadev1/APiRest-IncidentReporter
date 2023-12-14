package com.alfaDEV1.incidentReportApi.persistence.dto;

import com.alfaDEV1.incidentReportApi.persistence.entity.IncidentType;
import com.alfaDEV1.incidentReportApi.persistence.entity.Technician;
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

public class SpecialtyDTO {
    private Long id;
    private String name;
    private List<Technician> techniciansList = new ArrayList<>();
    private List<IncidentType> incidentTypeList = new ArrayList<>();
}
