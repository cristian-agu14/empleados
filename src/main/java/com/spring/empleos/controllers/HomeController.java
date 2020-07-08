package com.spring.empleos.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.empleos.models.Vacante;
import com.spring.empleos.service.IVacanteService;

@Controller
public class HomeController {

	@Autowired
	private IVacanteService serviceVacantes;

	@GetMapping("/")
	public String mostrarHome(Model model) {
		/*
		 * model.addAttribute("mensaje", "Bienvenidos a Empleos APP");
		 * model.addAttribute("fecha", new Date());
		 */

		List<Vacante> lista = serviceVacantes.buscarTodo();
		model.addAttribute("vacantes", lista);
		
		return "vacantes/listVacantes";
	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();

		lista.add("Auxilar contable");
		lista.add("Ingeniero de sistemas");
		lista.add("Psicólogo");
		lista.add("Arquitecto");

		model.addAttribute("empleos", lista);

		return "listado";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de Comunicaciones");
		vacante.setDescripcion("Se necesita ingeniero con o sin experiencia que de soporte en redes");
		vacante.setFecha(new Date());

		model.addAttribute("vacante", vacante);

		return "detalle";
	}

	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> list = serviceVacantes.buscarTodo();
		model.addAttribute("vacantes", list);

		return "tabla";
	}

}
