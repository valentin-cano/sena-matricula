package com.gozarte.matricula.entities;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "alumnos")
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(length = 20)
    private String nombre;

    @NotNull
    @Column(length = 30)
    private String apellidos;

    @NotNull
    @Column(length = 20)
    private String numeroDocumento;

    @NotNull
    @Column(length = 10)
    private String fechaNacimiento;

    @NotNull
    @Column(length = 15)
private String telefono;

}
