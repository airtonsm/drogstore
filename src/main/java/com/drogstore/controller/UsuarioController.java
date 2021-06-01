package com.drogstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.drogstore.entidades.Usuario;
import com.drogstore.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;


	@RequestMapping(method = RequestMethod.GET, value = "/cadastro_usuario")
	public ModelAndView cadastroUsuario() {
		ModelAndView modelAndView =  new ModelAndView("cadastro/cadastro_usuario");
		Iterable<Usuario> usuariosIt = usuarioRepository.findAll();
		modelAndView.addObject("usuarioobj", new Usuario());
		modelAndView.addObject("usuarios", usuariosIt);
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "**/salvarusuario")
	public ModelAndView salvar(Usuario usuario) {
		
		ModelAndView model = new ModelAndView("cadastro/cadastro_usuario");
		Iterable<Usuario> usuariosIt = usuarioRepository.findAll();
		model.addObject("usuarios", usuariosIt);
		model.addObject("usuarioobj", new Usuario());
		usuarioRepository.save(usuario);
		
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listarusuarios")
	public ModelAndView usuarios() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_usuario");
		Iterable<Usuario> usuariosIt = usuarioRepository.findAll();
		modelAndView.addObject("usuarios", usuariosIt);
		return modelAndView;
	}
	
	@GetMapping("/editarusuario/{idusuario}")
	public ModelAndView editar(@PathVariable("idusuario") Long idusuario) {
		 
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_usuario");
		Optional<Usuario> usuario = usuarioRepository.findById(idusuario);
		modelAndView.addObject("usuarioobj", usuario.get());
		Iterable<Usuario> usuariosIt = usuarioRepository.findAll();
		modelAndView.addObject("usuarios", usuariosIt);
		
		return modelAndView;
	}
	
	@GetMapping("/removeusuario/{idusuario}")
	public ModelAndView delete(@PathVariable("idusuario") Long idusuario) {
		
		usuarioRepository.deleteById(idusuario);
		
		ModelAndView model = new ModelAndView("cadastro/cadastro_usuario");
		model.addObject("usuarios", usuarioRepository.findAll());
		model.addObject("usuarioobj", new Usuario());
		
		return model;
	}

}
