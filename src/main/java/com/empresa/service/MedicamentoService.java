package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {
	
	public abstract Medicamento insertaActualiza(Medicamento obj);

	public abstract List<Medicamento> listaMedicamento();
	
	public abstract Optional<Medicamento> buscarPorId(int id);
	
	public abstract void eliminaPorId(int id);
}
