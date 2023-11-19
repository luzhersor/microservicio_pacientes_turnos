package com.example.pacientes.controller;

import com.example.pacientes.model.Paciente;
import com.example.pacientes.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {


    @Autowired
    private IPacienteService pacienteServ;

    //1. Create a new pacient
    @PostMapping("/pacientes/crear")
    public String crearCurso(@RequestBody Paciente pac){
        pacienteServ.savePaciente(pac);

        return "Paciente creado correctamente";
    }

    //2. Get all pacients
    @GetMapping("pacientes/traer")
    public List<Paciente> traerPacientes(){

        return pacienteServ.getPacientes();
    }

    //3. Delete pacient
    @DeleteMapping("/pacientes/borrar/{id}")
    public String deletePaciente(@PathVariable Long id){
        pacienteServ.deletePaciente(id);

        return "El paciente fue eliminado correctamente";
    }

    //4. Edit pacient
    @PutMapping("/pacientes/editar/{id_original}")
    public Paciente editPaciente(@PathVariable Long id_original,
                                 @RequestBody Paciente pacienteEditar){
        pacienteServ.editPaciente(id_original, pacienteEditar);
        Paciente pacienteEditado = pacienteServ.findPaciente(id_original);

        return pacienteEditado;
    }

    //5. Get pacient by id
    @GetMapping("/pacientes/traer/{id}")
    public Paciente traerPaciente (@PathVariable Long id) {
        return pacienteServ.findPaciente(id);
    }


    //6. Get by dni
    @GetMapping("/pacientes/traerdni/{dni}")
    public Paciente traerPacienteDni(@PathVariable String dni){
        return pacienteServ.findPacienteDni(dni);
    }
}
