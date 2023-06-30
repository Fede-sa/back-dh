package com.clinicaodontoligica.clinicaturnos.service;

import com.clinicaodontoligica.clinicaturnos.dto.PacienteDTO;
import com.clinicaodontoligica.clinicaturnos.entity.Paciente;
import com.clinicaodontoligica.clinicaturnos.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository iPacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public PacienteDTO crearPaciente(PacienteDTO pacienteDTO) {

        Paciente paciente = mapper.convertValue(pacienteDTO,  Paciente.class);
        iPacienteRepository.save(paciente);

        return pacienteDTO;
    }

    @Override
    public PacienteDTO modificarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        iPacienteRepository.save(paciente);

        return pacienteDTO;
    }

    @Override
    public PacienteDTO buscarPacienteId(Long id) {

        Optional<Paciente> paciente = iPacienteRepository.findById(id);

        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
           pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public List<PacienteDTO> listarPacientes() {
        List<Paciente> pacientes = iPacienteRepository.findAll();

        List<PacienteDTO> pacientesDTO = new ArrayList<>();

        for (Paciente paciente: pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }

    @Override
    public void borrarPaciente(Long id) {
        iPacienteRepository.deleteById(id);
    }

}
