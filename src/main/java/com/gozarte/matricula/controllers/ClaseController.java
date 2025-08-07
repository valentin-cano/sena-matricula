package com.gozarte.matricula.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody; // Importamos la anotación
import com.gozarte.matricula.entities.Alumno;
import com.gozarte.matricula.entities.Clase;
import com.gozarte.matricula.entities.DisponibilidadHoraria;
import com.gozarte.matricula.entities.DocenteMateria;
import com.gozarte.matricula.entities.Materia;
import com.gozarte.matricula.services.AlumnoService;
import com.gozarte.matricula.services.ClaseService;
import com.gozarte.matricula.services.DisponibilidadHorariaService;
import com.gozarte.matricula.services.DocenteMateriaService;
import com.gozarte.matricula.services.MateriaService;

@Controller
@RequestMapping("/clase")
public class ClaseController {

    private final AlumnoService alumnoService;
    private final ClaseService claseService;
    private final DisponibilidadHorariaService disponibilidadHorariaService;
    private final DocenteMateriaService docenteMateriaService;
    private final MateriaService materiaService;

    public ClaseController(AlumnoService alumnoService, ClaseService claseService,
            DisponibilidadHorariaService disponibilidadHorariaService, DocenteMateriaService docenteMateriaService,
            MateriaService materiaService) {
        this.alumnoService = alumnoService;
        this.claseService = claseService;
        this.disponibilidadHorariaService = disponibilidadHorariaService;
        this.docenteMateriaService = docenteMateriaService;
        this.materiaService = materiaService;
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioCrearClase(Model model) {
        List<Alumno> alumnos = alumnoService.listarAlumnos();
        model.addAttribute("alumnos", alumnos);
        List<DisponibilidadHoraria> disponibilidades = disponibilidadHorariaService.obtenerListaDeDisponibilidades();
        model.addAttribute("disponibilidades", disponibilidades);
        List<Materia> materias = materiaService.obtenerListaDeMaterias();
        model.addAttribute("materias", materias);
        return "crear_clase";
    }
@GetMapping("/lista")
public String listarClases(Model model) {
List<Clase> clases = claseService.listarClases();
model.addAttribute("clases", clases);
return "listar_clase";
}

    @GetMapping("/docentesPorMateria/{id}")
    @ResponseBody // Le dice a Spring que debe serializar el resultado a JSON
    public List<DocenteMateria> obtenerDocentesPorMateria(@PathVariable Long id) {
        return docenteMateriaService.obtenerDocentesPorMateriaId(id);
    }

    @GetMapping("/buscar/{id}")
    public String mostrarDocentesPorMateria(@PathVariable Long id, Model model) {
        List<DocenteMateria> docentesSeleccionados = docenteMateriaService.obtenerDocentesPorMateriaId(id);
        model.addAttribute("docentesSeleccionados", docentesSeleccionados);
        return "listar_clase"; 
    }

    @PostMapping("/eliminar")
    public String eliminarClase(@RequestParam Long idClase) {
        claseService.eliminarClase(idClase);
        return "redirect:/clase/lista";
    }

    @PostMapping("/guardar")
public String guardarClase(@ModelAttribute Clase clase) {
    // Guardamos la clase
    claseService.guardarClase(clase);

    // Obtener el ID de la disponibilidad seleccionada en el formulario
    Long idDisponibilidadSeleccionada = clase.getDisponibilidadHoraria().getId();

    // Marcar esa disponibilidad como no disponible
    disponibilidadHorariaService.marcarComoNoDisponible(idDisponibilidadSeleccionada);

    return "redirect:/clase/lista";
}


}