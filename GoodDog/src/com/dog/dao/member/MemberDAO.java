package com.dog.dao.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dog.vo.member.MemberVO;



public interface MemberDAO {
	
	// ȸ������ ��ȸ
	MemberVO selectMemberById(SqlSession session, String memId) throws SQLException;
	
	// ȸ������Ʈ ��ȸ
	List<MemberVO> selectMemberList(SqlSession session) throws SQLException;

	
	// ȸ�� �߰�
	public void insertMember(SqlSession session, MemberVO member) throws SQLException;
	
	// ȸ�� ����
	public void updateMember(SqlSession session, MemberVO member) throws SQLException;
	
	// ȸ�� ����
	void deleteMember(SqlSession session, String id) throws SQLException;
	
	// ȸ�� ����
	void disabledMember(SqlSession session, String id) throws SQLException;
	
	// ȸ�� Ȱ��ȯ
	void enabledMember(SqlSession session, String id) throws SQLException;
	
	MemberVO findMemberById(SqlSession session, String memName, String memRegNo, String memPhone ) throws SQLException;
	
}