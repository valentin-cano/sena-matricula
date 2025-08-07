package com.gozarte.matricula.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.gozarte.matricula.entities.Docente;
import com.gozarte.matricula.entities.DocenteMateria;
import com.gozarte.matricula.entities.Materia;
import com.gozarte.matricula.services.DocenteMateriaService;
import com.gozarte.matricula.services.DocenteService;
import com.gozarte.matricula.services.MateriaService;

@Controller
@RequestMapping("/docentemateria")
public class DocenteMateriaController {

    private final DocenteMateriaService docenteMateriaService;
    private final MateriaService materiaService;
    private final DocenteService docenteService;
    
    public DocenteMateriaController(DocenteMateriaService docenteMateriaService, MateriaService materiaService,
            DocenteService docenteService) {
        this.docenteMateriaService = docenteMateriaService;
        this.materiaService = materiaService;
        this.docenteService = docenteService;
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

    @PostMapping("actualizar")
    public String actualizar(@RequestParam Long id,
                             @RequestParam("id_docente") Long idDocente,
                             @RequestParam("id_materia") Long idMateria,
                             RedirectAttributes ra) {

        boolean ok = docenteMateriaService.actualizarDocenteMateria(id, idDocente, idMateria);
        if (!ok) {
            ra.addFlashAttribute("error", "No se encontró el docente por materia para actualizar.");
            return "redirect:/docentemateria/lista"; // Redirección correcta
        }
        ra.addFlashAttribute("success", "Docente por Materia actualizado correctamente.");
        return "redirect:/docentemateria/lista";
    }

    @GetMapping("/encontrar/{id}")
        public List<DocenteMateria> obtenerDocentesPorMateria(@PathVariable Long id) {
        return docenteMateriaService.obtenerDocentesPorMateriaId(id);
    }


        }