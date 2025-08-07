package com.gozarte.matricula.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clases")
public class Clase {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "alumno")
private Alumno alumno;

@ManyToOne
@JoinColumn(name = "materia")
private Materia materia;

@ManyToOne
@JoinColumn(name = "docente")
private Docente docente;

@ManyToOne
@JoinColumn(name =  "horario")
private Horario horario;

@ManyToOne
@JoinColumn(name = "id_disponibilidad")
private DisponibilidadHoraria disponibilidadHoraria;

public DisponibilidadHoraria getDisponibilidadHoraria() {
	return disponibilidadHoraria;
}

public void setDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {
	this.disponibilidadHoraria = disponibilidadHoraria;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Alumno getAlumno() {
	return alumno;
}

public void setAlumno(Alumno alumno) {
	this.alumno = alumno;
}

public Materia getMateria() {
	return materia;
}

public void setMateria(Materia materia) {
	this.materia = materia;
}

public Docente getDocente() {
	return docente;
}

public void setDocente(Docente docente) {
	this.docente = docente;
}

public Horario getHorario() {
	return horario;
}

public void setHorario(Horario horario) {
	this.horario = horario;
}


}