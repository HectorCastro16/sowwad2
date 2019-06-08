package com.clases.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping("/")	
	public ModelAndView index(ModelAndView model){
		model.addObject("titulo","ControlEventAPI");
		model.setViewName("index");
		return model;
	}

}
