package com.clinicaodontoligica.clinicaturnos.service;

import com.clinicaodontoligica.clinicaturnos.dto.OdontologoDTO;
import com.clinicaodontoligica.clinicaturnos.entity.Odontologo;
import com.clinicaodontoligica.clinicaturnos.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    private IOdontologoRepository iOdontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public OdontologoDTO crearOdontologo(OdontologoDTO odontologoDTO) {

        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(odontologo);

        return odontologoDTO;
    }

    @Override
    public OdontologoDTO modificarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(odontologo);

        return odontologoDTO;
    }

    @Override
    public OdontologoDTO buscarOdontologoId(Long id) {

        Optional<Odontologo> odontologo = iOdontologoRepository.findById(id);

        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public List<OdontologoDTO> listarOdontologos() {
        List<Odontologo> odontologos = iOdontologoRepository.findAll();

        List<OdontologoDTO> odontologosDTO = new ArrayList<>();

        for (Odontologo odontologo: odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
            return odontologosDTO;
    }

    @Override
    public void borrarOdontologo(Long id) {
        iOdontologoRepository.deleteById(id);
    }
}
