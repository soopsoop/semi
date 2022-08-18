package com.dog.dao.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dog.command.Criteria;
import com.dog.dto.member.MemberVO;



public interface MemberDAO {
	
	// ȸ������ ��ȸ
	MemberVO selectMemberById(SqlSession session, String memId) throws SQLException;
	
	int selectMemberListCount(Criteria cri)throws SQLException;
	
	// ȸ������Ʈ ��ȸ
	List<MemberVO> selectMemberList(Criteria cri) throws SQLException;

	
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
	
	MemberVO findMemberById(SqlSession session, String memMail ) throws SQLException;
	
}