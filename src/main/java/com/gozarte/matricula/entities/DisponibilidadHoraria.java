package com.gozarte.matricula.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "horarios_disponibles_por_profesor")
public class DisponibilidadHoraria {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "id_docente")
private Docente id_docente;

@ManyToOne
@JoinColumn(name = "id_horario")
private Horario id_horario;

@Column
private boolean disponible = true;

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

public Horario getId_horario() {
    return id_horario;
}

public void setId_horario(Horario id_horario) {
    this.id_horario = id_horario;
}

public boolean isDisponible() {
    return disponible;
}

public void setDisponible(boolean disponible) {
    this.disponible = disponible;
}

}