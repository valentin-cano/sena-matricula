package com.gozarte.matricula.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gozarte.matricula.entities.DisponibilidadHoraria;

@Repository
public interface DisponibilidadHorariaRepository extends JpaRepository<DisponibilidadHoraria, Long> {

//Método personalizado para filtrar la tabla por los campos id_docente y disponibilidad

    @Query(value = "SELECT * FROM horarios_disponibles_por_profesor WHERE id_docente = :docenteId AND disponible = true", 
           nativeQuery = true)
    List<DisponibilidadHoraria> findAllByIdDocenteAndDisponible(@Param("docenteId") Long docenteId);


}