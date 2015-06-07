package com.dongduk.movit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import com.dongduk.movit.api.MovieParser;
import com.dongduk.movit.domain.Member;
import com.dongduk.movit.service.MovitFacade;

@Controller
@Component
@SessionAttributes("userSession")
public class viewMainController {

	private MovitFacade movit;

	@Autowired
	public void setMovit(MovitFacade movit) {
		this.movit = movit;
	}

	@RequestMapping("/main.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			Member member, ModelAndView mav) throws Exception {

		if (member == null) {
			mav = new ModelAndView("Error", "message",
					"Invalid username or password.  Signon failed.");
			return mav;
		} else {
			System.out.println("m_id:" + member.getM_id());

			member = this.movit.getMember(member.getM_id(), member.getM_pw());
			UserSession userSession = new UserSession(member);
			mav = showAPI(mav);
			mav.addObject("userSession", userSession);
			mav.setViewName("main");
			return mav;
		}
	}

	@RequestMapping("/main2.do")
	public ModelAndView main2(
			@ModelAttribute("userSession") UserSession userSession,
			ModelAndView mav) throws Exception {
		mav = showAPI(mav);
		mav.addObject("userSession", userSession);
		mav.setViewName("main");
		return mav;
	}

	@RequestMapping(value = "JoinForm.do", method = RequestMethod.GET)
	public String joinForm() {
		return "JoinForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView join(Member member, ModelAndView mav) throws Exception {
		if (member == null) {
			mav = new ModelAndView("Error", "message",
					"Invalid username or password.  Signon failed.");
			return mav;
		} else {
			movit.insertMember(member);
			mav = showAPI(mav);
			UserSession userSession = new UserSession(member);
			mav.addObject("userSession", userSession);
			mav.setViewName("main");
			return mav;
		}
	}

	public ModelAndView showAPI(ModelAndView mav) throws Exception {
		MovieParser parser = new MovieParser();
		/*parser.init();

		mav.addObject("movie", parser.getRandMovie());
		mav.addObject("boxOffice", parser.getBoxOffice());
*/
		return mav;

	}
}
