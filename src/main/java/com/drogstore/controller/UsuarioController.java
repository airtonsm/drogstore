package com.drogstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.drogstone.model.Usuario;
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
	
	//public ModelAndView editar(@PathVariable("idusuario") Long idpessoa) {
		
		
		
	//}

}
