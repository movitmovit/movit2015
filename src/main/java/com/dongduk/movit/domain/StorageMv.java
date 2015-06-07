package com.dongduk.movit.domain;

@SuppressWarnings("serial")
public class StorageMv{

  /* Private Fields */
	private int memberIdx;
	private int movieIdx;
	private String rate;

  /* JavaBeans Properties */
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public int getMovieIdx() {
		return movieIdx;
	}
	public void setMovieIdx(int movieIdx) {
		this.movieIdx = movieIdx;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
}
