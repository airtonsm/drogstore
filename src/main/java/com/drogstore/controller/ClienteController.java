package com.drogstore.controller;

import com.drogstore.entidades.Cliente;
import com.drogstore.repository.ClienteRepository;
import com.drogstore.service.ClienteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ClienteController {

    @Autowired
    private ClienteServico servico;

    @RequestMapping(method = RequestMethod.GET, value = "/cadastro_cliente")
    public ModelAndView inicio(){
        ModelAndView model = new ModelAndView("cadastro/cadastro_cliente");
        return  model;

    }

    @RequestMapping(method = RequestMethod.POST, value = "**/salvarcliente")
    public ModelAndView salvar(Cliente cliente){

        ModelAndView model = new ModelAndView("cadastro/cadastro_cliente");
        servico.inserir(cliente);
        return model;
    }

}
