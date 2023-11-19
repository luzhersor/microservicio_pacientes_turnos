package com.example.pacientes.service;

import com.example.pacientes.model.Paciente;
import java.util.List;

public interface IPacienteService {

    public List<Paciente> getPacientes();
    public void savePaciente(Paciente pac);

    public void deletePaciente(Long id);
    public Paciente findPaciente(Long id);
    public void editPaciente (Long id_original, Paciente pac);
    public Paciente findPacienteDni(String dni);
}
