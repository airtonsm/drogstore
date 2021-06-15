package com.drogstore.controller;

import com.drogstore.entidades.Cliente;
import com.drogstore.repository.ClienteRepository;
import com.drogstore.service.ClienteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping("/pesquisarPessoa")
    public ModelAndView buscarPorNome(@RequestParam("nomepesquisa") String nomepesquisa){

        List<Cliente> clientes = servico.listarPorNome(nomepesquisa);

        ModelAndView model = new ModelAndView("vendas/pedido");
        model.addObject("clientesLista", clientes);
        return model;
    }



}
