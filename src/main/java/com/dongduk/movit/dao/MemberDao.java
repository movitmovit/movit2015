package com.dongduk.movit.dao;

import com.dongduk.movit.domain.Member;

public interface MemberDao {
	
	void insertMember(Member member);
	Member getMember(String m_id);
}
