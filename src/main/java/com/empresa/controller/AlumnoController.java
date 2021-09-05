package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {
	@Autowired
	private AlumnoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> lista(){
		List<Alumno> lista = service.lista();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Alumno> buscarId(@PathVariable("paramId") int id) {
		Optional<Alumno> optAlumno = service.buscarPorId(id);

		if (optAlumno.isPresent()) {
			return ResponseEntity.ok(optAlumno.get());

		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/dni/{paramId}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> buscarDni(@PathVariable("paramId") String id) {
		List<Alumno> lista = service.listaPorDni(id);

		if (CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

}
