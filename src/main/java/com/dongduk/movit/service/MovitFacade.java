package com.dongduk.movit.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dongduk.movit.domain.Member;
import com.dongduk.movit.domain.Movie;
import com.dongduk.movit.domain.StorageMv;
import com.dongduk.movit.domain.preferGenre;
import com.dongduk.movit.domain.WishMv;
@Component
public interface MovitFacade {
	
	//from MemberDao
	void insertMember(Member member);
	Member getMember(String m_id, String m_pw);
	
	
	//from mvselectdao
	void insertStorage(StorageMv s_mv);
	
	//5.22추가
	void updateStorage(StorageMv s_mv);
	//5.22추가
	void deleteStorage(StorageMv s_mv);
	
	void updateUser(Member mem);
	
	void insertWish(WishMv w_mv);

	void updateTasteGenre(preferGenre t_genre);

	//6.6
	List<WishMv> getWishList(int memberIdx);

	List<StorageMv> getStorageList(int memberIdx);
	
	//6.6
	Movie getMvInfo(int movieIdx);
	
	//6.4
	//boolean isStored(int movieIdx);
	int getStoredRate(int movieIdx);
	
	//from mypagedao
	List<String> getPreferDirector(int memberIdx);
	List<String> getPreferNation(int memberIdx);
	List<String> getPreferGenre(int memberIdx);

	int getTotalTime(int memberIdx);

	List<Double> getRateInfo(int memberIdx);
	
	//from service...
}
