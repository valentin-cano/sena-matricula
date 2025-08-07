package com.gozarte.matricula.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "docentes_materias")
public class DocenteMateria {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "id_docente")
private Docente id_docente;

@ManyToOne
@JoinColumn(name = "id_materia")
private Materia id_materia;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Docente getId_docente() {
	return id_docente;
}

public void setId_docente(Docente id_docente) {
	this.id_docente = id_docente;
}

public Materia getId_materia() {
	return id_materia;
}

public void setId_materia(Materia id_materia) {
	this.id_materia = id_materia;
}

}