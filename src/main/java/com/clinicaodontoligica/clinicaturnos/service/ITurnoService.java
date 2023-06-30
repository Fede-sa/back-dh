package com.clinicaodontoligica.clinicaturnos.service;

import com.clinicaodontoligica.clinicaturnos.dto.TurnoDTO;


import java.util.List;

public interface ITurnoService {

    public TurnoDTO crearTurno(TurnoDTO turnoDTO);

    public TurnoDTO modificarTurno(TurnoDTO turnoDTO);

    public TurnoDTO buscarTurnoId(Long id);

    public List<TurnoDTO> listarTurnos();

    public void borrarTurno(Long id);

}
