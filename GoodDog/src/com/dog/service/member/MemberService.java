package com.dog.service.member;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.dto.member.MemberVO;
import com.dog.exception.InvalidPasswordException;
import com.dog.exception.NotFoundIDException;


	public interface MemberService {
		
		// 로그인
		void login(String memId, String memPw) throws SQLException,NotFoundIDException, InvalidPasswordException;
		
		// 회원정보조회
		Map<String,Object> getMemberList(Criteria cri) throws SQLException;
		
		MemberVO getMember(String memId) throws SQLException;
		
		public void regist(MemberVO member) throws Exception;
		
		// 회원 수정
		void modify(MemberVO member) throws SQLException;
		
		// 회원 삭제
		void remove(String id) throws SQLException;
		
		// 회원 정지
		void disabled(String id) throws SQLException;
		
		// 회원 활성화
		void enabled(String id) throws SQLException;
		
		MemberVO findMemberById(String memName, String memMail) throws SQLException;

}
