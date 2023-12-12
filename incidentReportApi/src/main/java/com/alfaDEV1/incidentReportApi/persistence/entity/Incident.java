package com.alfaDEV1.incidentReportApi.persistence.entity;

import java.time.LocalDate;

public class Incident {
    private int idIncidente;
    private String descripcion;
    private String tipo;
    private LocalDate fechaReporte;
    private String estado;
    private boolean colchonHoras;
}
