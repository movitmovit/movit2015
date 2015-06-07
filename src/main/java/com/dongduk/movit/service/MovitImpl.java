package com.dongduk.movit.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongduk.movit.dao.MemberDao;
import com.dongduk.movit.dao.MvSelectDao;
import com.dongduk.movit.dao.mybatis.MybatisMemberDao;
//import com.dongduk.movit.dao.MvSelectDao;
import com.dongduk.movit.domain.Member;
import com.dongduk.movit.domain.Movie;
import com.dongduk.movit.domain.StorageMv;
import com.dongduk.movit.domain.preferGenre;
import com.dongduk.movit.domain.WishMv;

@Service
public class MovitImpl implements MovitFacade {
	/*
	 * @Autowired private MvSelectDao mvSelectDao;
	 */

	@Autowired
	private MybatisMemberDao memberDao;
	
	@Resource(name = "jdbcMvSelectDao")
	private MvSelectDao selectDao;
	
	
	
	//from memberdao
	@Override
	public Member getMember(String m_id, String m_pw) {
		// TODO Auto-generated method stub
		return memberDao.getMember(m_id, m_pw);
	}
	
	
	@Override
	public void insertMember(Member member) {
		// TODO Auto-generated method stub
		memberDao.insertMember(member);
	}
			
	//from mvselectdao
	@Override
	public void insertStorage(StorageMv s_mv) {
		// TODO Auto-generated method stub
		selectDao.insertStorage(s_mv);
	}
	
	public //5.22추가
	void updateStorage(StorageMv s_mv) {
		
	}
	//5.22추가
	public void deleteStorage(StorageMv s_mv) {
		
	}
	
	 //6.4
	public int getStoredRate(int movieIdx) {
		return selectDao.getStoredRate(movieIdx);
	}

	@Override
	public List<StorageMv> getStorageList(int memberIdx) {
		// TODO Auto-generated method stub
		return selectDao.getStorageList(memberIdx);
	}
	
	//6.6
	public Movie getMvInfo(int movieIdx) {
		return selectDao.getMvInfo(movieIdx);
	}

	@Override
	public void updateUser(Member mem) {
		// TODO Auto-generated method stub
		selectDao.updateUser(mem);
	}

	@Override
	public void insertWish(WishMv w_mv) {
		// TODO Auto-generated method stub
		selectDao.insertWish(w_mv);
	}

	@Override
	public void updateTasteGenre(preferGenre t_genre) {
		// TODO Auto-generated method stub
		selectDao.updateTasteGenre(t_genre);
	}

	//6.6
	@Override
	public List<WishMv> getWishList(int memberIdx) {
		// TODO Auto-generated method stub
		return selectDao.getWishList(memberIdx);
	}

	
	//from mypagedao
	@Override
	public List<String> getPreferDirector(int memberIdx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPreferNation(int memberIdx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPreferGenre(int memberIdx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalTime(int memberIdx) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Double> getRateInfo(int memberIdx) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
