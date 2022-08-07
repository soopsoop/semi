package com.dog.dao.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dog.vo.member.MemberVO;



public interface MemberDAO {
	
	// 회원정보 조회
	MemberVO selectMemberById(SqlSession session, String memId) throws SQLException;
	
	// 회원리스트 조회
	List<MemberVO> selectMemberList(SqlSession session) throws SQLException;

	
	// 회원 추가
	public void insertMember(SqlSession session, MemberVO member) throws SQLException;
	
	// 회원 수정
	public void updateMember(SqlSession session, MemberVO member) throws SQLException;
	
	// 회원 삭제
	void deleteMember(SqlSession session, String id) throws SQLException;
	
	// 회원 정지
	void disabledMember(SqlSession session, String id) throws SQLException;
	
	// 회원 활성환
	void enabledMember(SqlSession session, String id) throws SQLException;
	
}