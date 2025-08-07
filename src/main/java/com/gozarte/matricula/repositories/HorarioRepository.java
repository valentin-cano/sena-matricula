package com.gozarte.matricula.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gozarte.matricula.entities.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

//Método personalizado para excluir un id de la búsqueda en esta tabla

List<Horario> findByIdNot(Long id);

}