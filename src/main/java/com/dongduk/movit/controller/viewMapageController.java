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
public class viewMapageController {

	private MovitImpl movit;

// session에 저장되어있는 memberIdx로 해당 storageMv테이블 값 다 가져 오기
	@RequestMapping("/mypage.do")
	public String handleRequest(
		) throws Exception {
		//int memberIdx = userSession.getMember().getMemberIdx();
		
		return "Mypage"; 
				
	}

}
