package com.drogstore.controller;

import java.util.Optional;

import com.drogstore.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import com.drogstore.entidades.Usuario;
import com.drogstore.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping( value = "/cadastro_usuario")
	public ModelAndView cadastroUsuario() {
		ModelAndView modelAndView =  new ModelAndView("cadastro/cadastro_usuario");
		Iterable<Usuario> usuariosIt = service.listarTodos();
		modelAndView.addObject("usuarioobj", new Usuario());
		modelAndView.addObject("usuarios", usuariosIt);
		return modelAndView;
	}
	
	@PostMapping(value = "**/salvarusuario")
	public ModelAndView salvar(Usuario usuario) {
		
		ModelAndView model = new ModelAndView("cadastro/cadastro_usuario");
		Iterable<Usuario> usuariosIt = service.listarTodos();
		model.addObject("usuarios", usuariosIt);
		model.addObject("usuarioobj", new Usuario());
		service.inserir(usuario);

		service.listarUsuarios(usuario);
		return model;
	}
	
	@GetMapping(value = "/listarusuarios")
	public ModelAndView usuarios() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_usuario");
		Iterable<Usuario> usuariosIt = service.listarTodos();
		modelAndView.addObject("usuarios", usuariosIt);
		return modelAndView;
	}

	@GetMapping("/editarusuario/{idusuario}")
	public ModelAndView editar(@PathVariable("idusuario") Long idusuario) {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_usuario");
		Optional<Usuario> usuario = service.ListaPorId(idusuario);

		modelAndView.addObject("usuarioobj", usuario.get());
		Iterable<Usuario> usuariosIt = service.listarTodos(); // ao clicar em editar aqui devolver toda a lista

		modelAndView.addObject("usuarios", usuariosIt);
		return modelAndView;
	}
	
	@DeleteMapping("/removeusuario/{idusuario}")
	public ModelAndView delete(@PathVariable("idusuario") Long idusuario) {
		
		service.deletarPorId(idusuario);
		
		ModelAndView model = new ModelAndView("cadastro/cadastro_usuario");
		model.addObject("usuarios", service.listarTodos());
		model.addObject("usuarioobj", new Usuario());
		
		return model;
	}

}
