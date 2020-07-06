package com.spring.empleos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int id, Model model) {
		System.out.println("IdVacante-" + id);
		model.addAttribute("idVacante", id);
		return "vacantes/detalle";
	}

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrando vacante con el id: " + idVacante);
		model.addAttribute("idVacante", idVacante);
		return "mensaje";
	}

}
