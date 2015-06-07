package com.dongduk.movit.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
public class signoffController { 
	@RequestMapping("/signoff.do")
	public String handleRequest(HttpSession session) throws Exception {
		session.removeAttribute("userSession");
		session.invalidate();
		return "index";
	}
}
