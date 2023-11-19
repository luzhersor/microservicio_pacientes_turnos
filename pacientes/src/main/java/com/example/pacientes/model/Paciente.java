package com.example.pacientes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Getter @Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String telefono;

    //Constructor vacio publico
    public Paciente() {
    }

    //Constructor con argumentos público
    public Paciente(Long idPaciente, String dni, String nombre,
                    String apellido, LocalDate fechaNac, String telefono) {
        this.idPaciente = idPaciente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }
}
