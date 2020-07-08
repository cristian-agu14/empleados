package com.spring.empleos.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.empleos.models.Vacante;

@Service
public class VacantesServiceImple implements IVacanteService {

	private List<Vacante> vacantes = null;

	public VacantesServiceImple() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		vacantes = new LinkedList<Vacante>();

		try {
			Vacante vacante = new Vacante();
			vacante.setId(1L);
			vacante.setNombre("Ingeniero Civil");
			vacante.setDescripcion("Ingeniero civil con experiencia en estructuras");
			vacante.setSalario(2525000.0);
			vacante.setFecha(simpleDateFormat.parse("03-07-2020"));
			vacante.setDestacado(true);
			vacante.setImage("empresa1.png");

			Vacante vacante2 = new Vacante();
			vacante2.setId(2L);
			vacante2.setNombre("Psicologo organizacional");
			vacante2.setDescripcion("Psicologo con 2 años de experiencia en psicologia organizacional");
			vacante2.setSalario(3000000.0);
			vacante2.setFecha(simpleDateFormat.parse("08-10-2001"));
			vacante2.setDestacado(false);
			vacante2.setImage("empresa2.png");

			Vacante vacante3 = new Vacante();
			vacante3.setId(3L);
			vacante3.setNombre("Auxiliar contable");
			vacante3.setDescripcion("Tecnico o tecnologo contable");
			vacante3.setSalario(1000000.0);
			vacante3.setFecha(simpleDateFormat.parse("12-12-2019"));
			vacante3.setDestacado(false);

			Vacante vacante4 = new Vacante();
			vacante4.setId(4L);
			vacante4.setNombre("Profesor de ingles");
			vacante4.setDescripcion("Extrangero de habla inglesa con visa de trabajo actual");
			vacante4.setSalario(2000000.0);
			vacante4.setFecha(simpleDateFormat.parse("03-07-2020"));
			vacante4.setDestacado(true);
			vacante4.setImage("empresa4.png");

			vacantes.add(vacante);
			vacantes.add(vacante2);
			vacantes.add(vacante3);
			vacantes.add(vacante4);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Vacante> buscarTodo() {
		return vacantes;
	}

	@Override
	public Vacante findById(Long id) {

		for (Vacante v : vacantes) {
			if (v.getId() == id) {
				return v;
			}
		}

		return null;
	}

	@Override
	public void save(Vacante vacante) {
		vacantes.add(vacante);
	}

}
