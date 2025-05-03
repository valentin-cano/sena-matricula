package com.gozarte.matricula.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/docente")
public class DocenteController {

@GetMapping("/nuevo")
public String mostrarCrearDocente() {
return "crear_docente";
}

}