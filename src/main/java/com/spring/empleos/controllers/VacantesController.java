package com.spring.empleos.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.empleos.models.Vacante;
import com.spring.empleos.service.IVacanteService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IVacanteService serviceVacante;

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") Long id, Model model) {
		System.out.println("IdVacante-" + id);
		model.addAttribute("vacante", serviceVacante.findById(id));
		return "vacantes/detalle";
	}

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrando vacante con el id: " + idVacante);
		model.addAttribute("idVacante", idVacante);
		return "mensaje";
	}

	@GetMapping("/create")
	public String crear() {
		return "vacantes/formVacante";
	}

	/*
	 * Metodo recibiendo cada parametro con @RequetParam
	 * 
	 * @PostMapping("/save") public String guardar(@RequestParam("nombre") String
	 * nombre, @RequestParam("descripcion") String descripcion,
	 * 
	 * @RequestParam("categoria") String categoria, @RequestParam("estatus") String
	 * estatus,
	 * 
	 * @RequestParam("fecha") String fecha, @RequestParam("destacado") Boolean
	 * destacado,
	 * 
	 * @RequestParam("salario") Double salario, @RequestParam("detalles") String
	 * detalles) {
	 * 
	 * System.out.println("Nombre = " + nombre); System.out.println("Descripcion = "
	 * + descripcion); System.out.println("Categoria = " + categoria);
	 * System.out.println("estatus = " + estatus); System.out.println("fecha = " +
	 * fecha); System.out.println("DEstacado = " + destacado);
	 * System.out.println("Salario = " + salario); System.out.println("Detalles = "
	 * + detalles);
	 * 
	 * return "vacantes/listVacantes"; }
	 */

	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {

			return "vacantes/formVacante";
		}

		System.out.println("Vacante: " + vacante);
		serviceVacante.save(vacante);
		attributes.addFlashAttribute("msg", "Registro guardado con exíto!");

		return "redirect:/";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
