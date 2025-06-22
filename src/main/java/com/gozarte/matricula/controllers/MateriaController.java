package com.gozarte.matricula.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gozarte.matricula.entities.Alumno;
import com.gozarte.matricula.entities.Materia;
import com.gozarte.matricula.services.MateriaService;

@Controller
@RequestMapping("/materia")
public class MateriaController {

private final MateriaService materiaService;

public MateriaController(MateriaService materiaService) {
this.materiaService = materiaService;
}

@GetMapping("/nuevo")
public String mostrarFormularioMateria() {
return "crear_materia";
}

@GetMapping("/lista")
    public String listarMaterias(Model model) {
        List<Materia> materias = materiaService.obtenerListaDeMaterias(); 
        model.addAttribute("materias", materias); 
        return "listar_materia"; 
    }

@PostMapping("/guardar")
public String guardarMateria(Materia materia) {
materiaService.guardarMateria(materia);
return "redirect:/materia/lista";
}

@GetMapping("editar/{id}")
 public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
    Materia materia = materiaService.obtenerMateriaPorId(id);
    model.addAttribute("materia", materia);
    return "editar_materia"; 
}

@DeleteMapping("/eliminar")
public String eliminarMateria(@RequestParam("seleccionado") Long id) {    
    materiaService.eliminarMateria(id);
    return "redirect:/materia/lista";
    }


}