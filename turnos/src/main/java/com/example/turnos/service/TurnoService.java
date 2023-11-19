package com.example.turnos.service;

import com.example.turnos.model.Paciente;
import com.example.turnos.model.Turno;
import com.example.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepo;

    //Inyeccion de instancia
    @Autowired
    private RestTemplate apiConsumir;

    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        //buscar el paciente en la api pacientes
        //Paciente pac = //buscar en la api
        //String nombreCompletoPaciente = //lo que consumo de nombre de la API
        Paciente pac = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/"+dniPaciente, Paciente.class);
        String nombreCompletoPaciente = pac.getNombre()+""+pac.getApellido();

        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompletoPaciente);
        //turno.setNombreCompletoPaciente();

        turnoRepo.save(turno);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, Turno turno) {
         Turno turn= this.findTurno(id);

         turn.setFecha(turno.getFecha());
         turn.setNombreCompletoPaciente(turno.getTratamiento());
         turn.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

         turnoRepo.save(turn);
    }
}
