package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
	
	@Autowired
	private MedicamentoRepository repo;

	@Override
	public Medicamento insertaActualiza(Medicamento obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Medicamento> listaMedicamento() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Medicamento> buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void eliminaPorId(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
