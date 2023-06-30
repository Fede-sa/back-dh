package com.clinicaodontoligica.clinicaturnos.service;

import com.clinicaodontoligica.clinicaturnos.dto.PacienteDTO;


import java.util.List;

public interface IPacienteService {

    public PacienteDTO crearPaciente(PacienteDTO pacienteDTO);

    public PacienteDTO modificarPaciente(PacienteDTO pacienteDTO);

    public PacienteDTO buscarPacienteId(Long id);

    public List<PacienteDTO> listarPacientes ();

    public void borrarPaciente(Long id);
}
