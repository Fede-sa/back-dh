package com.clinicaodontoligica.clinicaturnos.service;

import com.clinicaodontoligica.clinicaturnos.dto.OdontologoDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;


    public void cargarData() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Jose");
        odontologoDTO.setApellido("Perez");
        odontologoDTO.setMatricula("025A");
        odontologoService.crearOdontologo(odontologoDTO);
    }


    @Test
    @Order(1)
    public void testCrearOdontologo (){

        cargarData();
        OdontologoDTO odontologoDTO1 = new OdontologoDTO();
        odontologoDTO1.setNombre("Federico");
        odontologoDTO1.setApellido("Rosales");
        odontologoDTO1.setMatricula("123A");
        odontologoService.crearOdontologo(odontologoDTO1);

        OdontologoDTO odontologo = odontologoService.buscarOdontologoId(2L);
        System.out.println(odontologo);
        assertTrue(odontologo.getMatricula().equals("123A"));

    }

    @Test
    @Order(2)
    public void testBuscarOdontologoId() {

        OdontologoDTO odontologoFederico = odontologoService.buscarOdontologoId(2L);

        assertTrue(odontologoFederico.getMatricula().equals("123A"));
    }

    @Test
    @Order(3)
    public void testBuscarTodosOdontologos() {

        List<OdontologoDTO> odontologos = odontologoService.listarOdontologos();

        assertTrue(odontologos.size()==2);
    }

    @Test
    @Order(4)
    public void testEliminarOdontologos() {

        odontologoService.borrarOdontologo(2L);

        assertTrue(odontologoService.buscarOdontologoId(2L)==null);
    }
}