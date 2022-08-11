package com.dog.dao.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dog.command.Criteria;
import com.dog.vo.member.MemberVO;



public interface MemberDAO {
	
	// 회원정보 조회
	MemberVO selectMemberById(String memId) throws SQLException;
	
	int selectMemberListCount(Criteria cri)throws SQLException;
	
	// 회원리스트 조회
	List<MemberVO> selectMemberList(Criteria cri) throws SQLException;

	
	// 회원 추가
	public void insertMember(MemberVO member) throws SQLException;
	
	// 회원 수정
	public void updateMember(MemberVO member) throws SQLException;
	
	// 회원 삭제
	void deleteMember(String memId) throws SQLException;
	
	// 회원 정지
	//void disabledMember(String memId) throws SQLException;
	
	// 회원 활성화
	//void enabledMember(String memId) throws SQLException;
	
}