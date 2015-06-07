package com.dongduk.movit.controller;

import java.io.Serializable;

import org.springframework.beans.support.PagedListHolder;

import com.dongduk.movit.domain.Member;

@SuppressWarnings("serial")
public class UserSession implements Serializable{

	private Member member;
	
	public Member getMember() {
		return member;
	}

	public UserSession(Member member) {
		this.member = member;
	}

}
