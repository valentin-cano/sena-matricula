package com.gozarte.matricula.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gozarte.matricula.entities.Docente;
import com.gozarte.matricula.repositories.DocenteRepository;

@Service
public class DocenteService {

private final DocenteRepository docenteRepository;

public DocenteService(DocenteRepository docenteRepository) {
this.docenteRepository = docenteRepository;
}

public void guardarDocente(Docente docente) {
docenteRepository.save(docente);
}

public List<Docente> listarDocentes() {
return docenteRepository.findAll();
}

public void eliminarDocente(Long identificador) {
docenteRepository.deleteById(identificador);
}

public Docente obtenerDocentePorid(Long id) {
return docenteRepository.findById(id)
.orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + id));
}

public void editarDocente(Docente docente) {
docenteRepository.save(docente);
}


}