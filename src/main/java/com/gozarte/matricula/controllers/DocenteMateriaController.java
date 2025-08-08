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
import com.gozarte.matricula.entities.Docente;
import com.gozarte.matricula.entities.DocenteMateria;
import com.gozarte.matricula.entities.Materia;
import com.gozarte.matricula.repositories.DocenteMateriaRepository;
import com.gozarte.matricula.repositories.DocenteRepository;
import com.gozarte.matricula.repositories.MateriaRepository;
import com.gozarte.matricula.services.DocenteMateriaService;
import com.gozarte.matricula.services.DocenteService;
import com.gozarte.matricula.services.MateriaService;

@Controller
@RequestMapping("/docentemateria")
public class DocenteMateriaController {

    private final DocenteMateriaService docenteMateriaService;
    private final MateriaService materiaService;
    private final DocenteService docenteService;
private final DocenteRepository docenteRepository;    
private final MateriaRepository materiaRepository;
private final DocenteMateriaRepository docenteMateriaRepository;


    public DocenteMateriaController(DocenteMateriaService docenteMateriaService, MateriaService materiaService,
        DocenteService docenteService, DocenteRepository docenteRepository, MateriaRepository materiaRepository,
        DocenteMateriaRepository docenteMateriaRepository) {
    this.docenteMateriaService = docenteMateriaService;
    this.materiaService = materiaService;
    this.docenteService = docenteService;
    this.docenteRepository = docenteRepository;
    this.materiaRepository = materiaRepository;
    this.docenteMateriaRepository = docenteMateriaRepository;
}

    @GetMapping("/nuevo")
    public String mostrarFormularioDocenteMate(Model model) {
        model.addAttribute("docenteMateria", new DocenteMateria());
        List<Materia> materias = materiaService.obtenerListaDeMaterias();
        model.addAttribute("materias", materias);
        List<Docente> docentes = docenteService.listarDocentes();
        model.addAttribute("docentes", docentes);
        return "crear_docente_materia"; // Es más claro usar un nombre de vista consistente
    }

    @GetMapping("/lista")
    public String listarDocenteMateria(Model model) {
        List<DocenteMateria> docenteMateria = docenteMateriaService.obtenerListaDocenteMateria(); 
        model.addAttribute("docenteMateria", docenteMateria); 
        return "listar_docente_materia"; 
    }

    @PostMapping("/guardar")
    public String guardardocenteMateria(DocenteMateria docenteMateria) {
        docenteMateriaService.guardarDocenteMateria(docenteMateria);
        return "redirect:/docentemateria/lista"; // Corregida la URL
    }

    @GetMapping("editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
        DocenteMateria docenteMateria = docenteMateriaService.obtenerDocenteMateriadPorId(id);
        model.addAttribute("docenteMateria", docenteMateria);
        model.addAttribute("docentes", docenteService.listarDocentes());
        model.addAttribute("materias", materiaService.obtenerListaDeMaterias());
        return "editar_docente_materia"; 
    }

    @PostMapping("/eliminar")
    public String eliminarDocenteMateria(@RequestParam("id") Long id) {
        docenteMateriaService.eliminarDocenteMateria(id);
        return "redirect:/docentemateria/lista";
    }


    @GetMapping("/encontrar/{id}")
        public List<DocenteMateria> obtenerDocentesPorMateria(@PathVariable Long id) {
        return docenteMateriaService.obtenerDocentesPorMateriaId(id);
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute DocenteMateria docenteMateria) {
        // Asegurar que el ID no sea null (es una edición)
        if (docenteMateria.getId() == null) {
            return "redirect:/docentemateria/lista";
        }
        // Buscar el Docente y la Materia por sus IDs para asegurar consistencia
        Long idDocente = docenteMateria.getId_docente().getId();
        Long idMateria = docenteMateria.getId_materia().getId();
        docenteRepository.findById(idDocente).ifPresent(docenteMateria::setId_docente);
        materiaRepository.findById(idMateria).ifPresent(docenteMateria::setId_materia);
        // Guardar la actualización
        docenteMateriaRepository.save(docenteMateria);
        return "redirect:/docentemateria/lista";
    }



        }