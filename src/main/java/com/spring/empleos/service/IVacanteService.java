package com.spring.empleos.service;

import java.util.List;

import com.spring.empleos.models.Vacante;

public interface IVacanteService {

	List<Vacante> buscarTodo();
	
	Vacante findById(Long id);
	
	void save(Vacante vacante);
	
}
