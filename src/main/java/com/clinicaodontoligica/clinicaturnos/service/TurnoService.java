package com.clinicaodontoligica.clinicaturnos.service;

import com.clinicaodontoligica.clinicaturnos.dto.TurnoDTO;
import com.clinicaodontoligica.clinicaturnos.entity.Turno;
import com.clinicaodontoligica.clinicaturnos.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private ITurnoRepository iTurnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public TurnoDTO crearTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        iTurnoRepository.save(turno);

        return turnoDTO;
    }

    @Override
    public TurnoDTO modificarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        iTurnoRepository.save(turno);

        return turnoDTO;
    }

    @Override
    public TurnoDTO buscarTurnoId(Long id) {
        Optional<Turno> turno = iTurnoRepository.findById(id);

        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public List<TurnoDTO> listarTurnos() {
        List<Turno> turnos = iTurnoRepository.findAll();

        List<TurnoDTO> turnosDTO = new ArrayList<>();

        for (Turno turno: turnos){
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }

    @Override
    public void borrarTurno(Long id) {
        iTurnoRepository.deleteById(id);
    }
}
