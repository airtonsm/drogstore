package com.drogstore.controller;

import com.drogstore.model.Pedido;
import com.drogstore.model.Produto;
import com.drogstore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class PedidoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/pedido")
    public ModelAndView inicio(){
        ModelAndView model = new ModelAndView("vendas/pedido");
        return model;
    }

//    public ModelAndView listar(Pedido pedido, Produto produto){
//
//        produtoRepository.findById(produto.getId());
//
//
//
//    }

}
