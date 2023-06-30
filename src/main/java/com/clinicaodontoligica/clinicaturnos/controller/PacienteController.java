package com.clinicaodontoligica.clinicaturnos.controller;


import com.clinicaodontoligica.clinicaturnos.dto.PacienteDTO;
import com.clinicaodontoligica.clinicaturnos.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> agregarPaciente (@RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO mostrarPaciente(@PathVariable Long id){
        return pacienteService.buscarPacienteId(id);
    }

    @GetMapping
    public List<PacienteDTO> mostrarTodosPacientes(){
        return pacienteService.listarPacientes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        pacienteService.borrarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> editarPaciente (@RequestBody PacienteDTO pacienteDTO){
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
