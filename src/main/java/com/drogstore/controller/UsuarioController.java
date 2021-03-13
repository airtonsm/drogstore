package com.drogstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "**/salvarusuario")
	public ModelAndView salvar(Usuario usuario) {
		
		ModelAndView model = new ModelAndView("cadastro/cadastro_usuario");
		
		usuarioRepository.save(usuario);
		
		return model;
	}

}
