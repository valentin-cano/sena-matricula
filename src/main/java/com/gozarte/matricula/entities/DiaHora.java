package com.gozarte.matricula.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dias_horas")
public class DiaHora {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(length = 10)
private String dia;

@Column(length = 15)
private String hora;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDia() {
	return dia;
}

public void setDia(String dia) {
	this.dia = dia;
}

public String getHora() {
	return hora;
}

public void setHora(String hora) {
	this.hora = hora;
}

}