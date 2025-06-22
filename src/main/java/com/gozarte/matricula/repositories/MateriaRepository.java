package com.gozarte.matricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gozarte.matricula.entities.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>{


}