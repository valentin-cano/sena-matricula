package com.gozarte.matricula.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.gozarte.matricula.entities.DisponibilidadHoraria;
import com.gozarte.matricula.repositories.DisponibilidadHorariaRepository;
import com.gozarte.matricula.repositories.DocenteRepository;
import com.gozarte.matricula.repositories.HorarioRepository;

@Service
public class DisponibilidadHorariaService {

private final DisponibilidadHorariaRepository disponibilidadHorariaRepository;
private final DocenteRepository docenteRepository;
private final HorarioRepository horarioRepository;

public DisponibilidadHorariaService(DisponibilidadHorariaRepository disponibilidadHorariaRepository,
		DocenteRepository docenteRepository, HorarioRepository horarioRepository) {
	this.disponibilidadHorariaRepository = disponibilidadHorariaRepository;
	this.docenteRepository = docenteRepository;
	this.horarioRepository = horarioRepository;
}



public void guardarDisponibilidad(DisponibilidadHoraria disponibilidadHoraria) {
disponibilidadHorariaRepository.save(disponibilidadHoraria);
}

public List<DisponibilidadHoraria> obtenerListaDeDisponibilidades() {
return disponibilidadHorariaRepository.findAll();
}

public DisponibilidadHoraria obtenerDisponibilidadPorId(Long id) {
return disponibilidadHorariaRepository.findById(id)
.orElseThrow(() -> new RuntimeException("No pudo ser encontrada la disponibilidad horaria con el id:" + id));
}

public void editarDisponibilidad(DisponibilidadHoraria disponibilidadHoraria) {
disponibilidadHorariaRepository.save(disponibilidadHoraria);
}

public void eliminarDisponibilidad(Long id) {
disponibilidadHorariaRepository.deleteById(id);
}


public List<DisponibilidadHoraria> obtenerDisponibilidadPorDocenteId(Long docenteId) {
    return disponibilidadHorariaRepository.findAllByIdDocenteAndDisponible(docenteId);
}

public void marcarComoDisponible(Long idDisponibilidad) {
        Optional<DisponibilidadHoraria> disponibilidadOpt = disponibilidadHorariaRepository.findById(idDisponibilidad);
        if (disponibilidadOpt.isPresent()) {
            DisponibilidadHoraria disponibilidad = disponibilidadOpt.get();
            disponibilidad.setDisponible(true);
            disponibilidadHorariaRepository.save(disponibilidad);
        } else {
            throw new RuntimeException("No se encontró la disponibilidad con ID: " + idDisponibilidad);
        }
    }

public void marcarComoNoDisponible(Long idDisponibilidad) {
        Optional<DisponibilidadHoraria> disponibilidadOpt = disponibilidadHorariaRepository.findById(idDisponibilidad);
        if (disponibilidadOpt.isPresent()) {
            DisponibilidadHoraria disponibilidad = disponibilidadOpt.get();
            disponibilidad.setDisponible(false);
            disponibilidadHorariaRepository.save(disponibilidad);
        } else {
            throw new RuntimeException("No se encontró la disponibilidad con ID: " + idDisponibilidad);
        }
    }




}