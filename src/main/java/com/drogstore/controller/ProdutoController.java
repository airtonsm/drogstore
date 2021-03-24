package com.drogstore.controller;

import com.drogstore.model.Produto;
import com.drogstore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
    public class ProdutoController {

        @Autowired
        private ProdutoRepository produtoRepository;

        @RequestMapping(method = RequestMethod.GET, value = "/cadastro_produto")
        public ModelAndView inicio(){
            ModelAndView model = new ModelAndView("/cadastro/cadastro_produto");
            return model;
        }

        @RequestMapping(method = RequestMethod.POST, value = "/salvarproduto")
        public ModelAndView salvar(Produto produto){

            ModelAndView model = new ModelAndView("cadastro/cadastro_produto");
            produtoRepository.save(produto);

            return model;
        }

        @PostMapping("**/pesquisarMed")
            public ModelAndView pesquisar(@RequestParam("medPesquisa") String medPesquisa){

                List<Produto> produtos = new ArrayList<Produto>();

                produtos = produtoRepository.findProdutoByNome(medPesquisa);

                ModelAndView model = new ModelAndView("vendas/pedido");
                model.addObject("produtos", produtos);

                return model;
            }


    }
