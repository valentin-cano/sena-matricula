package com.gozarte.matricula.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/materia")
public class MateriaController {

@GetMapping("/nuevo")
public String mostrarCrearMateria() {
return "crear_materia";
}


}