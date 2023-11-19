package com.example.turnos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter @Setter
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turno;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    private String tratamiento;
    private String nombreCompletoPaciente;




}
