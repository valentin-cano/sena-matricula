package com.gozarte.matricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gozarte.matricula.entities.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long>{

}