package com.gozarte.matricula.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "dias")
@Data
public class Dia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 10)
    private String dia;

    @ManyToMany
    @JoinTable(
        name = "dias_horas",
        joinColumns = @JoinColumn(name = "dia_id"),
        inverseJoinColumns = @JoinColumn(name = "hora_id")
    )
    private List<Hora> horas;
}
