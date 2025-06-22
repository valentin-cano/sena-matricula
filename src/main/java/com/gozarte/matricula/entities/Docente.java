package com.gozarte.matricula.entities;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "docentes")
public class Docente {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(length = 20)
private String nombre;

@Column(length = 30)
private String apellidos;

@Column(length = 20)
private String numeroDocumento;

@Column(length = 10)
private String fechaNacimiento;

@Column(length = 15)
private String telefono;

@Column(length = 30)
private String correo;


    @ManyToMany
    @JoinTable(
        name = "docentes_materias",
        joinColumns = @JoinColumn(name = "docente_id"),
        inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private Set<Materia> materias;


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public String getNumeroDocumento() {
        return numeroDocumento;
    }


    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    public String getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public Set<Materia> getMaterias() {
        return materias;
    }


    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }



}