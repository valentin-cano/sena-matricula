package com.gozarte.matricula.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "horas")
@Data
public class Hora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 15)
    private String hora;

@ManyToMany(mappedBy = "horas")
private List<Dia> dias;


}
