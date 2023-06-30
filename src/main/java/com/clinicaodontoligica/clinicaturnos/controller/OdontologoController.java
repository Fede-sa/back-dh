package com.clinicaodontoligica.clinicaturnos.controller;

import com.clinicaodontoligica.clinicaturnos.dto.OdontologoDTO;
import com.clinicaodontoligica.clinicaturnos.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> agregarOdontologo (@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO mostrarOdontologo(@PathVariable Long id){
        return odontologoService.buscarOdontologoId(id);
    }

    @GetMapping
    public List<OdontologoDTO> mostrarTodosOdontologos(){
        return odontologoService.listarOdontologos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.borrarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> editarOdontologo (@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
