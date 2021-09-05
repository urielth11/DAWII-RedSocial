package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository repo;

	@Override
	public Alumno insertaActualiza(Alumno obj) {
		return null;
	}

	@Override
	public List<Alumno> lista() {
		return repo.findAll();
	}

	@Override
	public Optional<Alumno> buscarPorId(int id) {
		return repo.findById(id);
	}

	@Override
	public void eliminaPorId(int id) {
		
	}

	@Override
	public List<Alumno> listaPorDni(String id) {
		return repo.findByDni(id);
	}

}
