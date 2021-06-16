package com.drogstore.controller;

import com.drogstore.entidades.*;
import com.drogstore.repository.PedidoProdutoRepository;
import com.drogstore.repository.ProdutoRepository;
import com.drogstore.service.ClienteServico;
import com.drogstore.service.PedidoServico;
import com.drogstore.service.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class PedidoController {

    @Autowired
    ProdutoServico produtoServico;

    @Autowired
    PedidoServico pedidoServico;

    @Autowired
    ClienteServico clienteServico;


    @GetMapping(value = "/pedido")
    public ModelAndView inicio(){
        ModelAndView model = new ModelAndView("vendas/pedido");
        Cliente cliente = new Cliente();
        cliente.setNome("Oriosvaldo");
        model.addObject("clienteobj", cliente);
        return model;
    }

    @PostMapping("/salvarPedido")
    public ModelAndView salvarPedido(Pedido pedido){
        ModelAndView model = new ModelAndView("vendas/pedido");
        pedidoServico.salvar(pedido);
        return  model;
    }

    @GetMapping("/addCliente/{idcliente}")
    public ModelAndView adicionarCliente(@PathVariable("idcliente") Long idcliente){

        Optional<Cliente> cliente = clienteServico.listarPorId(idcliente);

        ModelAndView model = new ModelAndView("vendas/pedido");
        model.addObject("clienteobj", cliente.get());

        return model;
    }


    @GetMapping(value = "/addprodutopedido/{idproduto}")
    public ModelAndView adicionarProduto(@PathVariable("idproduto") Long idproduto){
        ModelAndView model = new ModelAndView("vendas/pedido");
        return model;
    }

    @GetMapping("**/pesquisarProduto")
    public ModelAndView pesquisar(@RequestParam("medPesquisa") String medPesquisa){
        List<Produto> produtos;
        ModelAndView model = new ModelAndView("vendas/pedido");
        produtos = produtoServico.listarPorNome(medPesquisa);
        model.addObject("produtos", produtos);

        return model;
    }
}
