package com.gozarte.matricula.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gozarte.matricula.entities.Alumno;
import com.gozarte.matricula.services.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/lista")
    public String listarAlumnos(Model model) {
        List<Alumno> alumnos = alumnoService.listarAlumnos(); 
        model.addAttribute("alumnos", alumnos); 
        return "listar_alumno"; 
    }

    
    @GetMapping("/nuevo")
    public String mostrarFormularioAlumno() {      
        return "crear_alumno";
    }

    @PostMapping("/guardar")
public String guardarAlumno(@ModelAttribute Alumno alumno) {
        alumnoService.guardarAlumno(alumno);
    return "redirect:/alumno/lista";
    }

@PostMapping("/eliminar")
public String eliminarAlumno(@RequestParam("seleccionado") Long id) {    
    alumnoService.eliminarAlumno(id);
    return "redirect:/alumno/lista";
    }


 @GetMapping("/editar/{id}")
 public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
    Alumno alumno = alumnoService.obtenerAlumnoPorId(id);
    model.addAttribute("alumno", alumno);
    return "editar_alumno"; 
}
   
}
