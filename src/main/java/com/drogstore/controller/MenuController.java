package com.drogstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MenuController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/menusistema")
	public ModelAndView initPage() {
		
		ModelAndView modelAndView = new ModelAndView("menusistema");		
		return modelAndView;
	}


}
