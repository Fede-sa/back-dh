package com.clinicaodontoligica.clinicaturnos.service;


import com.clinicaodontoligica.clinicaturnos.dto.PacienteDTO;
import com.clinicaodontoligica.clinicaturnos.entity.Domicilio;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;

    public void cargarData() {
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
    public void testCrearPaciente (){

        cargarData();
        PacienteDTO pacienteDTO1 = new PacienteDTO();
        pacienteDTO1.setNombre("Rosa");
        pacienteDTO1.setApellido("Rosas");
        pacienteDTO1.setDni("12312344");
        pacienteDTO1.setFechaAlta(Timestamp.valueOf(LocalDate.of(2020,7,20).atStartOfDay()));
        pacienteDTO1.setDomicilio(new Domicilio("Belgrano", "1111", "San Luis", "San Luis"));
        pacienteService.crearPaciente(pacienteDTO1);

        PacienteDTO paciente = pacienteService.buscarPacienteId(2L);
        System.out.println(paciente);
        assertTrue(paciente.getDni().equals("12312344"));
    }

    @Test
    @Order(2)
    public void testBuscarPacienteId() {

        PacienteDTO pacienteRosa = pacienteService.buscarPacienteId(2L);

        assertTrue(pacienteRosa.getDni().equals("12312344"));
    }

    @Test
    @Order(3)
    public void testBuscarTodosPacientes() {

        List<PacienteDTO> pacientes = pacienteService.listarPacientes();

        assertTrue(pacientes.size()==2);
    }

    @Test
    @Order(4)
    public void testEliminarPaciente() {

        pacienteService.borrarPaciente(2L);

        assertTrue(pacienteService.buscarPacienteId(2L)==null);
    }

}
