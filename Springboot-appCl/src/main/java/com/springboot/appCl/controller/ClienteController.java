package com.springboot.appCl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.appCl.models.entity.Clientes;
import com.springboot.appCl.models.service.IClienteServiceImplement;

@Controller
@RequestMapping("/Views/Clientes")
public class ClienteController {
	
	
	@Autowired
	private IClienteServiceImplement ClienteService;

	@GetMapping("/index")
	public String listarClientes (Model model) {
		
		List<Clientes> listarClientes = ClienteService.ListarTodos();
		
		model.addAttribute("titulo", "Lista de clientes");
		model.addAttribute("Clientes", listarClientes);
		return "/Views/Clientes/lista";
		
		
	}
	
	@GetMapping("/edit/Views/Clientes/save")
	public String listarrClientes (Model model, Clientes cliente) {
		
		List<Clientes> listarClientes = ClienteService.ListarTodos();
		
		model.addAttribute("titulo", "Lista de clientes");
		model.addAttribute("Clientes", listarClientes);
		ClienteService.guardar(cliente);
		return "/Views/Clientes/lista";
		
		
	}
	
	@GetMapping("/create")
	public String crear ( Model model) {
		
		Clientes cliente = new Clientes();
		
		model.addAttribute("titulo", "Formulario: Nuevo cliente");
		model.addAttribute("cliente", cliente);
		
		
		return "/Views/Clientes/frmCrear";
	}

	
	@PostMapping("/Views/Clientes/save")
	public String guardar (@ModelAttribute Clientes cliente) {
		
		ClienteService.guardar(cliente);
		
		return "redirect:/Views/Clientes/index";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editar (@PathVariable("id") Long idCliente, Model model) {
		
		Clientes cliente = ClienteService.buscarporID(idCliente);
		
		model.addAttribute("titulo", "Formulario: editar cliente");
		model.addAttribute("cliente", cliente);
		
		
		return "/Views/Clientes/frmeditar";
	}
	
	
	@GetMapping("/delete/{id}")
	public String eliminar (@PathVariable("id") Long idCliente) {
		
		ClienteService.Eliminar(idCliente);
		
		return "redirect:/Views/Clientes/index";
	}
	
	
}

