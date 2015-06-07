package com.dongduk.movit.dao;

import java.util.List;

public interface MypageDao {

	List<String> getPreferDirector(int memberIdx);
	List<String> getPreferNation(int memberIdx);
	List<String> getPreferGenre(int memberIdx);
	//(각각 칼럼 director 상위 3개/ nation 상위 5개/ genre 상위 13개 가져오는 메소드)

	// calculPercent --> service..
	//(각 편수/총편 수) 

	int getTotalTime(int memberIdx);
	//(TotalTime 가져와서 범위별로 문구를 출력하는 메소드)


	List<Double> getRateInfo(int memberIdx);
	// m_rateAvg, m_commonRate, m_totalRate 꺼내오
}
