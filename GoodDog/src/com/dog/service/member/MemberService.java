package com.dog.service.member;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.vo.member.MemberVO;


	public interface MemberService {
		
		
		//void login(String memId, String memPw) throws SQLException;
		Map<String,Object> getMemberList(Criteria cri) throws SQLException;
		
		MemberVO getMember(String memId) throws SQLException;
		
		public void regist(MemberVO member) throws Exception;
		
		public void modify(MemberVO member) throws Exception;
		
		public void remove(String memId) throws Exception;
		
		//public void disabled(String id) throws SQLException;
		
		//public void enabled(String id) throws SQLException;

}
