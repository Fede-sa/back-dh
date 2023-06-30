package com.clinicaodontoligica.clinicaturnos.controller;

import com.clinicaodontoligica.clinicaturnos.dto.TurnoDTO;
import com.clinicaodontoligica.clinicaturnos.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
   private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> agregarTurno (@RequestBody TurnoDTO turnoDTO){
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO mostrarTurno(@PathVariable Long id){
        return turnoService.buscarTurnoId(id);
    }

    @GetMapping
    public List<TurnoDTO> mostrarTodosTurnos(){
        return turnoService.listarTurnos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        turnoService.borrarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> editarTurno (@RequestBody TurnoDTO turnoDTO){
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
