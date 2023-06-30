package com.clinicaodontoligica.clinicaturnos.service;

import com.clinicaodontoligica.clinicaturnos.dto.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void testCrearOdontologo (){

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Federico");
        odontologoDTO.setApellido("Rosales");
        odontologoDTO.setMatricula("123A");
        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontolo = odontologoService.buscarOdontologoId(1L);

        assertTrue(odontolo !=null);
    }
}