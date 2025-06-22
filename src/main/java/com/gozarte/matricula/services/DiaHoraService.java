package com.gozarte.matricula.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gozarte.matricula.entities.DiaHora;
import com.gozarte.matricula.repositories.DiaHoraRepository;

@Service
public class DiaHoraService {

private final DiaHoraRepository diaHoraRepository;

public DiaHoraService(DiaHoraRepository diaHoraRepository) {
this.diaHoraRepository = diaHoraRepository;
}

public List<DiaHora> obtenerTodasLasHorasYDias() {
return diaHoraRepository.findAll();
}

public List<DiaHora> obtenerExceptoId(Long id) {
return diaHoraRepository.findByIdNot(id);
}


}