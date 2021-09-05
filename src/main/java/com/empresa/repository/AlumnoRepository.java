package com.empresa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	
	//Optional<Alumno> findByDni(int storeNumber);
	public List<Alumno> findByDni(String dni);
}
