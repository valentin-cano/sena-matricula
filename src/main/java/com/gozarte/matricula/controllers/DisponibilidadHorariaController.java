package com.gozarte.matricula.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gozarte.matricula.entities.DisponibilidadHoraria;
import com.gozarte.matricula.entities.Docente;
import com.gozarte.matricula.entities.Horario;
import com.gozarte.matricula.services.DisponibilidadHorariaService;
import com.gozarte.matricula.services.DocenteService;
import com.gozarte.matricula.services.HorarioService;

//Tiene que ser controlador de tipo RestController para que retorne datos de tipo Json
@Controller
@RequestMapping("/disponibilidad")
public class DisponibilidadHorariaController {

    private final DisponibilidadHorariaService disponibilidadHorariaService;
    private final HorarioService horarioService;
    private final DocenteService docenteService;

    //Constructor que inyecta todas las dependencias
    public DisponibilidadHorariaController(
        DisponibilidadHorariaService disponibilidadHorariaService,
        HorarioService horarioService,
        DocenteService docenteService
    ) {
        this.disponibilidadHorariaService = disponibilidadHorariaService;
        this.horarioService = horarioService;
        this.docenteService = docenteService;
    }

    
//En el siguiente método se importan los servicios de docente y horario para utilizarlos en los botones de seleccionar en la plantilla
@GetMapping("/nuevo")
public String mostrarFormularioDisponibilidad(Model model) {
    // Objeto vacío para el formulario
    model.addAttribute("disponibilidad", new DisponibilidadHoraria());
    // Lista de horarios
    List<Horario> horarios = horarioService.obtenerTodasLasHorasYDias();
    model.addAttribute("horarios", horarios);
    // Lista de docentes
    List<Docente> docentes = docenteService.listarDocentes();
    model.addAttribute("docentes", docentes);
    return "crear_disponibilidad";
}

@GetMapping("/lista")
    public String listarDisponibilidad(Model model) {
        List<DisponibilidadHoraria> disponibilidad = disponibilidadHorariaService.obtenerListaDeDisponibilidades(); 
        model.addAttribute("disponibilidad", disponibilidad); 
        return "listar_disponibilidad"; 
    }

@PostMapping("/guardar")
public String guardarDisponibilidad(DisponibilidadHoraria disponibilidad) {
    disponibilidadHorariaService.guardarDisponibilidad(disponibilidad);
return "redirect:/disponibilidad/lista";
}

@GetMapping("editar/{id}")
 public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
    DisponibilidadHoraria disponibilidadHoraria = disponibilidadHorariaService.obtenerDisponibilidadPorId(id);
    model.addAttribute("disponibilidadHoraria", disponibilidadHoraria);
model.addAttribute("disponibilidad", disponibilidadHoraria);
model.addAttribute("docentes", docenteService.listarDocentes());
model.addAttribute("horarios", horarioService.obtenerTodasLasHorasYDias());
    return "editar_disponibilidad"; 
}

@PostMapping("/eliminar")
public String eliminarDisponibilidad(@RequestParam("id") Long id) {
    disponibilidadHorariaService.eliminarDisponibilidad(id);
    return "redirect:/disponibilidad/lista";
}

 @GetMapping("/encontrar/{id}")
@ResponseBody
 public List<DisponibilidadHoraria> obtenerDisponibilidadPorDocente(@PathVariable Long id) {
    return disponibilidadHorariaService.obtenerDisponibilidadPorDocenteId(id);
}       


}