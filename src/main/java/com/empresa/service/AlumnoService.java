package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Alumno;

public interface AlumnoService {
	public abstract Alumno insertaActualiza(Alumno obj);

	public abstract List<Alumno> lista();
	
	public abstract Optional<Alumno> buscarPorId(int id);
	
	public abstract void eliminaPorId(int id);
	
	public abstract List<Alumno> listaPorDni(String id);
}
