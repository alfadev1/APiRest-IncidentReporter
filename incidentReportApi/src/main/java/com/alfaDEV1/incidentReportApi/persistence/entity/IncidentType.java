package com.alfaDEV1.incidentReportApi.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class IncidentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIncidentType")
    private Long id;
    private String name;
    private int estimatedTime;
    private int maximumTime;
    @OneToMany(
            mappedBy = "incidentType",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Incident> incidentList= new ArrayList<>();
    @ManyToMany(mappedBy = "incidentTypeList")
    @JsonIgnore
    private List<Specialty> specialtyList = new ArrayList<>();

}
