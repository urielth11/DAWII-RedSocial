package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;

@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> lista(){
		List<Medicamento> lista = service.listaMedicamento();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamento> inserta(@RequestBody Medicamento obj){
		Medicamento objSalida = service.insertaActualiza(obj);
		return ResponseEntity.ok(objSalida);
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Medicamento> acualiza(@RequestBody Medicamento obj){
		if(obj == null) {
			return ResponseEntity.badRequest().build();
		}else {
			Optional<Medicamento> optMedicamento = service.buscarPorId(obj.getIdMedicamento());
			if(optMedicamento.isPresent()) {
				Medicamento objActualizado = service.insertaActualiza(obj);
				return ResponseEntity.ok(objActualizado);
			}else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@DeleteMapping("/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento> elimina(@PathVariable("paramId") int id){
		Optional<Medicamento> optMedicamento = service.buscarPorId(id);
		
		if(optMedicamento.isPresent()) {
			service.eliminaPorId(id);
			Optional<Medicamento> optEliminado = service.buscarPorId(id);
			
			if(optEliminado.isPresent()) {
				return ResponseEntity.badRequest().build();
			}else {
				return ResponseEntity.ok(optMedicamento.get());
			}
			
		}else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
