package com.dongduk.movit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dongduk.movit.domain.Movie;
import com.dongduk.movit.domain.StorageMv;
import com.dongduk.movit.domain.WishMv;
import com.dongduk.movit.service.MovitImpl;

@Controller
//@SessionAttributes("userSession")
@Component
public class viewWishController {

	@Autowired
	private MovitImpl movit;
	
// session에 저장되어있는 memberIdx로 해당 storageMv테이블 값 다 가져 오기
	@RequestMapping("/wishlist.do")
	public ModelAndView wish(HttpServletRequest request) throws Exception {
		System.out.println("Wish Controller");
		
		ModelAndView mv = new ModelAndView();
		//int memberIdx = userSession.getMember().getMemberIdx();
		
		//현재는 임의로
		int memberIdx = 2;
		//session의 memberIdx로 사용자의 storageMv목록 get
		List<WishMv> wishList = movit.getWishList(memberIdx);
		System.out.println("wishList size: " + wishList.size());
		System.out.println(wishList.get(0).getMemberIdx() + ", " + wishList.get(0).getMovieIdx());
		System.out.println(wishList.get(1).getMemberIdx() + ", " + wishList.get(1).getMovieIdx());
		
		List<Movie> movieList = new ArrayList();
		
		//storageMv의 movieIdx에 해당하는 영화들의 정보 get
		for(WishMv wish : wishList){
			System.out.println(wish.getMovieIdx());
			movieList.add(movit.getMvInfo(wish.getMovieIdx()));
		}
		
		mv.setViewName("Wishlist");
		mv.addObject("wishList", wishList);
		mv.addObject("movieList", movieList);
		
		return mv; 		
	}

}
