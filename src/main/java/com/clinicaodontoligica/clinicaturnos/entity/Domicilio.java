package com.clinicaodontoligica.clinicaturnos.entity;

import javax.persistence.*;

@Entity
@Table (name = "Domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String numeracion;
    private String provincia;
    private String localidad;

    @OneToOne(mappedBy = "domicilio")
    private Paciente paciente;

    public Domicilio() {
    }

    public Domicilio(String calle, String numeracion, String provincia, String localidad, Paciente paciente) {
        this.calle = calle;
        this.numeracion = numeracion;
        this.provincia = provincia;
        this.localidad = localidad;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
