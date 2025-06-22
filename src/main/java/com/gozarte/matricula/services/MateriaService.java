package com.gozarte.matricula.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gozarte.matricula.entities.Materia;
import com.gozarte.matricula.repositories.MateriaRepository;

@Service
public class MateriaService {

private final MateriaRepository materiaRepository;

public MateriaService(MateriaRepository materiaRepository) {
this.materiaRepository = materiaRepository;
}

public void guardarMateria(Materia materia) {
materiaRepository.save(materia);
}

public List<Materia> obtenerListaDeMaterias() {
return materiaRepository.findAll();
}

public Materia obtenerMateriaPorId(Long id) {
return materiaRepository.findById(id)
.orElseThrow(() -> new RuntimeException("No pudo ser encontrada la materia con el id:" + id));
}

public void editarMateria(Materia materia) {
materiaRepository.save(materia);
}

public void eliminarMateria(Long id) {
materiaRepository.deleteById(id);;
}

}