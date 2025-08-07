package com.gozarte.matricula.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.gozarte.matricula.entities.DocenteMateria;
import com.gozarte.matricula.repositories.DocenteMateriaRepository;
import com.gozarte.matricula.repositories.DocenteRepository;
import com.gozarte.matricula.repositories.MateriaRepository;
import jakarta.transaction.Transactional;

@Service
public class DocenteMateriaService {

private final DocenteMateriaRepository docenteMateriaRepository;
private final DocenteRepository docenteRepository;
private final MateriaRepository materiaRepository;

public DocenteMateriaService(DocenteMateriaRepository docenteMateriaRepository, DocenteRepository docenteRepository,
        MateriaRepository materiaRepository) {
    this.docenteMateriaRepository = docenteMateriaRepository;
    this.docenteRepository = docenteRepository;
    this.materiaRepository = materiaRepository;
}

public void guardarDocenteMateria(DocenteMateria docenteMateria) {
docenteMateriaRepository.save(docenteMateria);
}

public List<DocenteMateria> obtenerListaDocenteMateria() {
return docenteMateriaRepository.findAll();
}

public DocenteMateria obtenerDocenteMateriadPorId(Long id) {
return docenteMateriaRepository.findById(id)
.orElseThrow(() -> new RuntimeException("No pudo ser encontrado el docente por materia horaria con el id:" + id));
}

public void editarDocenteMateria(DocenteMateria docenteMateria) {
docenteMateriaRepository.save(docenteMateria);
}

public void eliminarDocenteMateria(Long id) {
docenteMateriaRepository.deleteById(id);;
}

    @Transactional
public boolean actualizarDocenteMateria(Long id, Long idDocente, Long idMateria) {
    Optional<DocenteMateria> opt = docenteMateriaRepository.findById(id);
    if (opt.isEmpty()) {
        return false;
    }
    DocenteMateria disp = opt.get();

    // Asigna docente si existe
    if (docenteRepository.findById(idDocente).isPresent()) {
        docenteRepository.findById(idDocente).ifPresent(disp::setId_docente);
    } else {
        return false; // no existe el docente
    }

    // Asigna materia si existe
    if (docenteMateriaRepository.findById(idMateria).isPresent()) {
        materiaRepository.findById(idMateria).ifPresent(disp::setId_materia);
    } else {
        return false; // no existe la materia
    }
return true;
}

    public List<DocenteMateria> obtenerDocentesPorMateriaId(Long materiaId) {
        return docenteMateriaRepository.findAllByIdMateria(materiaId);
                   }



}