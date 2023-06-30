package com.clinicaodontoligica.clinicaturnos.service;


import com.clinicaodontoligica.clinicaturnos.dto.OdontologoDTO;


import java.util.List;

public interface IOdontologoService {



    public OdontologoDTO crearOdontologo(OdontologoDTO odontologoDTO);

    OdontologoDTO modificarOdontologo(OdontologoDTO odontologoDTO);

    public OdontologoDTO buscarOdontologoId(Long id);

    public List<OdontologoDTO> listarOdontologos ();

    public void borrarOdontologo(Long id);
}
