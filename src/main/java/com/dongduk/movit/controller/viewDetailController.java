package com.dongduk.movit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dongduk.movit.domain.Member;
import com.dongduk.movit.domain.Movie;
import com.dongduk.movit.domain.MovieCommand;
import com.dongduk.movit.domain.StorageMv;
import com.dongduk.movit.domain.WishMv;
import com.dongduk.movit.service.MovitImpl;


@Controller
@Component
@SessionAttributes("userSession")
public class viewDetailController {
	
	@Autowired
	MovitImpl movit;
	
	
	
	//처음 상세정보 띄울때는 평가하기폼(get), 한번 평가하면 자신이 매김 평점과 다시평가하기(post)
	@RequestMapping("/detail.do")
	public ModelAndView detail(HttpServletRequest request,
			@ModelAttribute("userSession") UserSession userSession,
			@ModelAttribute("command") MovieCommand command
			//@RequestParam(value="rating", required=false) String rating,
			) throws Exception {
		
		System.out.println("viewDetailController 들어옴");
		ModelAndView mav = new ModelAndView();
		
		StorageMv storage = new StorageMv();
		//이 영화를 평가한 적이 있는지 확인 -> mvStorage에 해당 movie idx 검색, 존재시 afterratingdetail 페이지로, rate출력
		if (request.getMethod().equalsIgnoreCase("post")) {
			//post로 들어오면  1. movie 테이블에 해당 영화 존재하는지 확인 2. 존재시 해당movieidx로 insertstorage. 3. 존재안할시 movie 테이블에 추가, 새로 생긴 movieidx로 insertStorage
			System.out.println("post로 들어옴");
			System.out.println(command.getRate());
			System.out.println(command.getDirector());
			System.out.println(command.getTitle());
			
			//movit.seachMv -> insertMovie 하거나 말거나 하고 MovieIdx뽑아오기./ memberidx는 session에서 rate는 command에서
			Member member = userSession.getMember();
			
			storage.setMemberIdx(member.getMemberIdx());
			storage.setMovieIdx(2);//임의로
			storage.setRate(command.getRate());
			
			movit.insertStorage(storage);
			mav.setViewName("afterRatingDetail");
		}
		else 
			//update, delete
			mav.setViewName("detail");
		return mav;
	}
	
	@RequestMapping("/addWish.do")
	public ModelAndView addWish(HttpServletRequest request,
			@ModelAttribute("userSession") UserSession userSession,
			@ModelAttribute("command") MovieCommand command
			//@RequestParam(value="rating", required=false) String rating,
			) throws Exception {
		
		System.out.println("viewDetailController /addWish.do 들어옴");
		ModelAndView mav = new ModelAndView();
		WishMv wish = new WishMv();
		//memberIdx 는 session에서
		Member member = userSession.getMember();
		
		wish.setMemberIdx(member.getMemberIdx());
		//movieIdx는 parameter로 받아와야됨
		wish.setMovieIdx(2);
		movit.insertWish(wish);
		mav.setViewName("afterAddWishDetail");
		return mav;
	}
	
	//선택한 영화 제목과 감독으로 세부사항 뽑아오는 알고리즘 
	
	//영화 평점 넘어와서 mvStorage에 영화와 함께 저장 

}
