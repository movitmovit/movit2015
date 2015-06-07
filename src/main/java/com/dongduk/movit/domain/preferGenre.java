package com.dongduk.movit.domain;

@SuppressWarnings("serial")
public class preferGenre {
	/* Private Fields */
	private int memberIdx;
	private String genre;
	private String score;
	
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
}
