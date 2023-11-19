package com.example.turnos.controller;

import com.example.turnos.dto.TurnoDTO;
import com.example.turnos.model.Turno;
import com.example.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoServ;

    //1. Create new turn
    @PostMapping("/crear")
    public String crearTurno(@RequestBody TurnoDTO turno) {
        turnoServ.saveTurno(turno.getFecha(), turno.getTratamiento(), turno.getDniPaciente());

        return "Turno creado correctamente";
    }

    /*@PostMapping("/crear")
    public String crearTurno(@RequestBody LocalDate fecha,
                             @RequestBody String tratamiento,
                             @RequestBody String dniPaciente){
        turnoServ.saveTurno(fecha, tratamiento, dniPaciente);

        return "Turno creado correctamente";
    }*/



    //2. Get all turns
    @GetMapping("/traer")
    public List<Turno> traerTurnos(){
        return turnoServ.getTurnos();
    }

    //3. Eliminar un turno
    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id){
        turnoServ.deleteTurno(id);

        return "El turno fue eliminado exitosamente";
    }

    //4. Editar turno
    @PutMapping("/editar/{id_original}")
    public Turno editTurno(@PathVariable Long id_original,
                           @RequestBody Turno turnoEditar){

        turnoServ.editTurno(id_original, turnoEditar);

        //Buscando el turno editado para mostrarlo
        Turno turnoEditado = turnoServ.findTurno(id_original);

        return turnoEditado;
    }

    //5. Get turn by Id
    @GetMapping("/traer/{id}")
    public Turno traerTurno(@PathVariable Long id){
        return turnoServ.findTurno(id);
    }


}
