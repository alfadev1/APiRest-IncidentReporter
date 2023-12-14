package com.alfaDEV1.incidentReportApi.persistence.dto;

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

public class OperatorDTO {
    private String name;
    private List<Incident> incidentlist = new ArrayList<>();
}
