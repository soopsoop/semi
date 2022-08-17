package com.dog.service.member;


import java.sql.SQLException;
import java.util.List;

import com.dog.dto.member.MemberVO;
import com.dog.exception.InvalidPasswordException;
import com.dog.exception.NotFoundIDException;


	public interface MemberService {
		
		// 로그인
		void login(String memId, String memPw) throws SQLException,NotFoundIDException, InvalidPasswordException;
		
		// 회원정보조회
		MemberVO getMember(String id) throws SQLException;
		
		// 회원리스트조회
		List<MemberVO> getMemberList() throws SQLException;

		
		// 회원 등록
		public void regist(MemberVO member) throws SQLException;
		
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
