package com.gozarte.matricula.entities;

import java.util.Set;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "docentes")
@Data
public class Docente {

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

@NotNull
@Column(length = 30)
private String correo;


    @ManyToMany
    @JoinTable(
        name = "docentes_materias",
        joinColumns = @JoinColumn(name = "docente_id"),
        inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private Set<Materia> materias;



}