package com.gozarte.matricula.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gozarte.matricula.entities.Clase;
import com.gozarte.matricula.repositories.ClaseRepository;

@Service
public class ClaseService {

private final ClaseRepository claseRepository;
private final DisponibilidadHorariaService disponibilidadHorariaService;

public ClaseService(ClaseRepository claseRepository, DisponibilidadHorariaService disponibilidadHorariaService) {
	this.claseRepository = claseRepository;
	this.disponibilidadHorariaService = disponibilidadHorariaService;
}

public void guardarClase(Clase clase) {
claseRepository.save(clase);
}

public List<Clase> listarClases() {
return claseRepository.findAll();
}

public void eliminarClase(Long id) {
claseRepository.deleteById(id);
}

public void editarClase(Clase clase) {
claseRepository.save(clase);
}

    



}