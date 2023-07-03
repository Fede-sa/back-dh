package com.clinicaodontoligica.clinicaturnos.dto;

import com.clinicaodontoligica.clinicaturnos.entity.Domicilio;


import java.sql.Timestamp;
import java.util.Date;

public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Domicilio domicilio;
    private Timestamp fechaAlta;

    public PacienteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
