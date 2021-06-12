package com.drogstore.controller;

import com.drogstore.entidades.Produto;
import com.drogstore.repository.PedidoProdutoRepository;
import com.drogstore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PedidoController {

    @Autowired
    ProdutoRepository produtoRepository;

    PedidoProdutoRepository pedidoRepository;

    @GetMapping(value = "/pedido")
    public ModelAndView inicio(){
        ModelAndView model = new ModelAndView("vendas/pedido");
        return model;
    }





}
