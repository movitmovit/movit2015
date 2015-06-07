/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.dongduk.movit.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.dongduk.movit.domain.Member;

/**
 * @author Eduardo Macarron
 *
 */
public interface MemberMapper {

//  Member getMemberByUsername(String m_id);

  Member getMemberByUsernameAndPassword(@Param("m_id") String m_id, @Param("m_pw") String m_pw);
  
  void insertMember(Member member);

/*  List<String> getMembernameList();
  
  void insertAccount(Member member);
  
  void insertProfile(Member member);
  
  void insertSignon(Member member);

  void updateAccount(Member member);

  void updateProfile(Member member);

  void updateSignon(Member member);*/

}
