package com.drogstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
    public class ProdutoController {

        @RequestMapping(method = RequestMethod.GET, value = "/cadastro_produto")
        public ModelAndView inicio(){
            ModelAndView model = new ModelAndView("/cadastro/cadastro_produto");
            return model;
        }


    }
