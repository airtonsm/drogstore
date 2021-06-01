package com.drogstore.controller;

import com.drogstore.entidades.Cliente;
import com.drogstore.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/cadastro_cliente")
    public ModelAndView inicio(){

        ModelAndView model = new ModelAndView("cadastro/cadastro_cliente");
        return  model;

    }

    @RequestMapping(method = RequestMethod.POST, value = "**/salvarcliente")
    public ModelAndView salvar(Cliente cliente){

        ModelAndView model = new ModelAndView("cadastro/cadastro_cliente");
        clienteRepository.save(cliente);

        return model;
    }

}
