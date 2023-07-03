package com.clinicaodontoligica.clinicaturnos.service;


import com.clinicaodontoligica.clinicaturnos.dto.OdontologoDTO;
import com.clinicaodontoligica.clinicaturnos.dto.PacienteDTO;
import com.clinicaodontoligica.clinicaturnos.dto.TurnoDTO;
import com.clinicaodontoligica.clinicaturnos.entity.Domicilio;
import com.clinicaodontoligica.clinicaturnos.entity.Odontologo;
import com.clinicaodontoligica.clinicaturnos.entity.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Timestamp;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TurnoServiceTest {

    @Autowired
    private ITurnoService turnoService;
    @Autowired
    private IOdontologoService odontologoService;
    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    ObjectMapper mapper;

    public void cargarData() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Jose");
        odontologoDTO.setApellido("Perez");
        odontologoDTO.setMatricula("025A");
        odontologoService.crearOdontologo(odontologoDTO);

        PacienteDTO pacienteDTO= new PacienteDTO();
        pacienteDTO.setNombre("Mario");
        pacienteDTO.setApellido("Fernandez");
        pacienteDTO.setDni("35353535");
        pacienteDTO.setFechaAlta(Timestamp.valueOf(LocalDate.of(2023,3,15).atStartOfDay()));
        pacienteDTO.setDomicilio(new Domicilio("San Martin", "1122", "San Luis", "San Luis"));
        pacienteService.crearPaciente(pacienteDTO);


    }

    @Test
    @Order(1)
    public void testCrearTurno(){

        cargarData();
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setFechaTurno(Timestamp.valueOf(LocalDate.of(2023,6,25).atStartOfDay()));
        turnoDTO.setPaciente(mapper.convertValue(pacienteService.buscarPacienteId(1L), Paciente.class));
        turnoDTO.setOdontologo(mapper.convertValue(odontologoService.buscarOdontologoId(1L), Odontologo.class));

       turnoService.crearTurno(turnoDTO);

        TurnoDTO turnoCreado = turnoService.buscarTurnoId(1L);

        assertTrue(turnoCreado != null);
        assertTrue(turnoCreado.getPaciente().getNombre().equals("Mario"));

    }

    @Test
    @Order(2)
    public void testBuscarTurno(){

        TurnoDTO turnoCreado = turnoService.buscarTurnoId(1L);
        assertTrue(turnoCreado.getOdontologo().getNombre().equals("Jose"));
    }


}
