package com.gozarte.matricula.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gozarte.matricula.entities.Horario;
import com.gozarte.matricula.repositories.HorarioRepository;

@Service
public class HorarioService {

private final HorarioRepository horarioRepository;

public HorarioService(HorarioRepository horarioRepository) {
this.horarioRepository = horarioRepository;
}

public List<Horario> obtenerTodasLasHorasYDias() {
return horarioRepository.findAll();
}

public List<Horario> obtenerExceptoId(Long id) {
return horarioRepository.findByIdNot(id);
}


}