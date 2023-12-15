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
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSpecialty")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "specialty",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Technician> techniciansList = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "specialty_incidentType",
            joinColumns = @JoinColumn(name = "idSpecialty"),
            inverseJoinColumns = @JoinColumn(name = "idIncidentType")
            )
    @JsonIgnore
    private List<IncidentType> incidentTypeList = new ArrayList<>();
}
