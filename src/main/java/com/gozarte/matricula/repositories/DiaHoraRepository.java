package com.gozarte.matricula.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gozarte.matricula.entities.DiaHora;

@Repository
public interface DiaHoraRepository extends JpaRepository<DiaHora, Long> {

//Método personalizado para excluir un id de la búsqueda en esta tabla

List<DiaHora> findByIdNot(Long id);

}