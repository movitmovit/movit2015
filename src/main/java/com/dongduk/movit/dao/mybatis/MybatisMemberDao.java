package com.dongduk.movit.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.dongduk.movit.dao.MemberDao;
import com.dongduk.movit.dao.mybatis.mapper.MemberMapper;
import com.dongduk.movit.domain.Member;

/**
 * @author Juergen Hoeller
 * @author Colin Sampaleanu
 */
@Repository
public class MybatisMemberDao implements MemberDao {

	@Autowired
	private MemberMapper MemberMapper;
	
/*	public Member getAccount(String m_id) throws DataAccessException {
		return accountMapper.getAccountByUsername(m_id);
	}*/

	public Member getMember(String m_id, String m_pw) 
			throws DataAccessException {
		return MemberMapper.getMemberByUsernameAndPassword(m_id, m_pw);
	}

	@Override
	public void insertMember(Member member) throws DataAccessException {
		MemberMapper.insertMember(member);
		// TODO Auto-generated method stub

	}

	@Override
	public Member getMember(String m_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
