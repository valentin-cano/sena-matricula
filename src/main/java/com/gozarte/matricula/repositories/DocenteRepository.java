package com.gozarte.matricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gozarte.matricula.entities.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long>{


}