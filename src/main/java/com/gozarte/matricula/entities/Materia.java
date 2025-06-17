package com.gozarte.matricula.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "materias")
@Data
public class Materia {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(length = 50)
private String nombre;

@Column(length = 300)
private String descripcion;

    @ManyToMany(mappedBy = "materias")
    private Set<Docente> docentes;



}