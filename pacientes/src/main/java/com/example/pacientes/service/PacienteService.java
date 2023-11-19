package com.example.pacientes.service;

import com.example.pacientes.model.Paciente;
import com.example.pacientes.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacienteRepo;


    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public void savePaciente(Paciente pac) {
        pacienteRepo.save(pac);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepo.deleteById(id);
    }

    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepo.findById(id).orElse(null);
    }

    @Override
    public void editPaciente(Long id_original, Paciente pac) {
        this.savePaciente(pac);
    }

    @Override
    public Paciente findPacienteDni(String dni) {
        return pacienteRepo.findByDni(dni);
    }
}
