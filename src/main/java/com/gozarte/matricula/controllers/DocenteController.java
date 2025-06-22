package com.gozarte.matricula.controllers;

import org.springframework.ui.Model;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gozarte.matricula.entities.Docente;
import com.gozarte.matricula.services.DocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {

private final DocenteService docenteService;

public DocenteController(DocenteService docenteService) {
this.docenteService = docenteService;
}


@GetMapping("/nuevo")
public String mostrarCrearDocente() {
return "crear_docente";
}

    @GetMapping("/lista")
    public String listarDocentes(Model model) {
        List<Docente> docentes = docenteService.listarDocentes(); 
        model.addAttribute("docentes", docentes); 
        return "listar_docente"; 
    }

    @PostMapping("/guardar")
public String guardarDocente(@ModelAttribute Docente docente) {
docenteService.guardarDocente(docente);
    return "redirect:/docente/lista";
    }

@PostMapping("/eliminar")
public String eliminarDocente(@RequestParam("seleccionado") Long id) {    
    docenteService.eliminarDocente(id);
    return "redirect:/docente/lista";
    }


 @GetMapping("/editar/{id}")
 public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
    Docente docente = docenteService.obtenerDocentePorid(id);
    model.addAttribute("docente", docente);
    return "editar_docente"; 
}
  


}