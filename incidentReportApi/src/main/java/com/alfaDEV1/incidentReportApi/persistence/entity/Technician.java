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
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTechnician")
    private Long id;
    private String name;
    private String lastName;
    private String email;
    @ManyToOne
    @JoinColumn(name = "idSpecialty")
    private Specialty specialty;
    @OneToMany(
            mappedBy = "technician",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Incident> incidentsList = new ArrayList<>();


}
