package com.gozarte.matricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gozarte.matricula.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{


}