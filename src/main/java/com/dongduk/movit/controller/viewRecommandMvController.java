package com.dongduk.movit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dongduk.movit.service.MovitImpl;

@Controller
//@SessionAttributes("userSession")
@Component
public class viewRecommandMvController {

	private MovitImpl movit;

	@RequestMapping("/recommand.do")
	public String handleRequest(
		) throws Exception {
		
		return "RecommandMv"; 
	}
}
