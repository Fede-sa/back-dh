package com.clinicaodontoligica.clinicaturnos.dto;

import com.clinicaodontoligica.clinicaturnos.entity.Odontologo;
import com.clinicaodontoligica.clinicaturnos.entity.Paciente;


import java.util.Date;

public class TurnoDTO {

    private Odontologo odontologo;
    private Paciente paciente;
    private Date fechaTurno;

    public TurnoDTO() {
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }
}
