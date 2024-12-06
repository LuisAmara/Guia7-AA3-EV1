package com.springboot.appCl.models.service;

import java.util.List;

import com.springboot.appCl.models.entity.Clientes;

public interface I_Cliente_Service {
	
	public List<Clientes> ListarTodos();
	public void guardar (Clientes cliente);
	public Clientes buscarporID(Long id);
	public void Eliminar (Long id);

}
