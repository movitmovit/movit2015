package com.dongduk.movit.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Member implements Serializable{
	/* Private Fields */
	private int memberIdx;
	
	private String m_id;
	private String m_pw;
	private String m_name;
	private float m_rateAvg;
	private float m_commonRate;
	private float m_totalRate;// int -> double
	private int m_totalTime;
	
	 /* JavaBeans Properties */	

	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public float getM_rateAvg() {
		return m_rateAvg;
	}
	public void setM_rateAvg(float m_rateAvg) {
		this.m_rateAvg = m_rateAvg;
	}
	public float getM_commonRate() {
		return m_commonRate;
	}
	public void setM_commonRate(float m_commonRate) {
		this.m_commonRate = m_commonRate;
	}
	public float getM_totalRate() {
		return m_totalRate;
	}
	public void setM_totalRate(float m_totalRate) {
		this.m_totalRate = m_totalRate;
	}
	public int getM_totalTime() {
		return m_totalTime;
	}
	public void setM_totalTime(int m_totalTime) {
		this.m_totalTime = m_totalTime;
	}
	

}
