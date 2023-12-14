package com.alfaDEV1.incidentReportApi.persistence.dto;

import com.alfaDEV1.incidentReportApi.persistence.entity.Incident;
import com.alfaDEV1.incidentReportApi.persistence.entity.Specialty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TechnicianDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Specialty specialty;
    private List<Incident> incidentsList;
}
