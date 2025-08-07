package com.gozarte.matricula.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gozarte.matricula.entities.DocenteMateria;

@Repository
public interface DocenteMateriaRepository extends JpaRepository<DocenteMateria, Long> {

//Método personalizado para encontrar un docente según el id de la materia jpql
    @Query("SELECT dm FROM DocenteMateria dm WHERE dm.id_materia.id = :materiaId")
List<DocenteMateria> findAllByIdMateria(@Param("materiaId") Long materiaId);

}