package com.dongduk.movit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dongduk.movit.domain.Movie;
import com.dongduk.movit.domain.MovieCommand;
import com.dongduk.movit.domain.StorageMv;
import com.dongduk.movit.service.MovitImpl;

@Controller
@SessionAttributes("userSession")
@Component
public class viewMvStorageController {

	@Autowired
	private MovitImpl movit;
	
// session에 저장되어있는 memberIdx로 해당 storageMv테이블 값 다 가져 오기
	@RequestMapping("/storage.do")
	public ModelAndView storage(HttpServletRequest request,
			@ModelAttribute("userSession") UserSession userSession) throws Exception {
		System.out.println("Storage Controller");
		
		ModelAndView mv = new ModelAndView();
	
		int memberIdx = userSession.getMember().getMemberIdx();
		System.out.println("session memberIdx" + userSession.getMember().getMemberIdx());
		
		//session의 memberIdx로 사용자의 storageMv목록 get
		List<StorageMv> storageList = movit.getStorageList(memberIdx);
		System.out.println("storageList size: " + storageList.size());
		System.out.println(storageList.get(0).getMemberIdx() + ", " + storageList.get(0).getMovieIdx() + ", " + storageList.get(0).getRate());
		System.out.println(storageList.get(1).getMemberIdx() + ", " + storageList.get(1).getMovieIdx() + ", " + storageList.get(1).getRate());
		
		List<Movie> movieList = new ArrayList();
		
		//storageMv의 movieIdx에 해당하는 영화들의 정보 get
		for(StorageMv storage : storageList){
			System.out.println(storage.getMovieIdx());
			movieList.add(movit.getMvInfo(storage.getMovieIdx()));
		}
		
		mv.setViewName("MvStorage");
		mv.addObject("storageList", storageList);
		mv.addObject("movieList", movieList);
		
		return mv; 		
	}

}
