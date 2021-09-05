package com.empresa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "alumno")
@Data
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlumno;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "fechaNacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
}
