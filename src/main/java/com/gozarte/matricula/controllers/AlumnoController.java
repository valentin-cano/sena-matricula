package com.gozarte.matricula.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {


@GetMapping("/nuevo")
public String mostrarCrearAlumno() {
return "crear_alumno";
}
}