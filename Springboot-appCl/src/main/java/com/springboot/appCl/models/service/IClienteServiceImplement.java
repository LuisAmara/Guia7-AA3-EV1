package com.springboot.appCl.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.appCl.models.entity.Clientes;
import com.springboot.appCl.models.repository.Cliente_Repository;


@Service
public class IClienteServiceImplement implements I_Cliente_Service {

	
	@Autowired
	private Cliente_Repository ClienteRepository;
	@Override
	public List<Clientes> ListarTodos() {
		return (List<Clientes>) ClienteRepository.findAll();
	}

	@Override
	public void guardar(Clientes cliente) {	
		ClienteRepository.save(cliente);
	}

	@Override
	public Clientes buscarporID(Long id) {
		return ClienteRepository.findById(id).orElse(null);
	}

	@Override
	public void Eliminar(Long id) {
		ClienteRepository.deleteById(id);;
	}

	
	
	
	
	
	
}
