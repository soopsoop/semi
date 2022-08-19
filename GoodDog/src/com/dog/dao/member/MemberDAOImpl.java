		package com.dog.dao.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dog.command.Criteria;
import com.dog.dto.member.MemberVO;



public class MemberDAOImpl implements MemberDAO {

	private SqlSessionFactory SqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.SqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public MemberVO selectMemberById(SqlSession session, String memId) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", memId);
		return member;
	}

	@Override
	public void insertMember(SqlSession session,MemberVO member) throws SQLException {
		try {			  
			session.update("Member-Mapper.insertMember",member);
		}catch(Exception e) {
			//����ó��
			throw e;
		}finally {
			if(session != null)session.close();
		}
		
	}

	@Override
	public void updateMember(SqlSession session, MemberVO member) throws SQLException {
		session.update("Member-Mapper.updateMember", member);
	}

	@Override
	public void deleteMember(SqlSession session, String id) throws SQLException {
		session.update("Member-Mapper.deleteMember", id);
	}

	@Override
	public void disabledMember(SqlSession session, String id) throws SQLException {
		session.update("Member-Mapper.disabledMember", id);
	}

	@Override
	public void enabledMember(SqlSession session, String id) throws SQLException {
		session.update("Member-Mapper.enabledMember", id);
	}

	@Override
	public MemberVO findMemberById(SqlSession session,String memMail) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.findMemberById", memMail);
		return member;
	}

	public int selectMemberListCount(Criteria cri) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			
			int count = session.selectOne("Member-Mapper.selectMemberListCount",cri);			
			return count;
		}catch(Exception e) {
			//����ó��
			throw e;
		}finally {
			if(session != null)session.close();
		}
		
	}

	@Override
	public List<MemberVO> selectMemberList(Criteria cri) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			int offset = cri.getStartRowNum();
			int limit = cri.getPerPageNum();
			RowBounds rowBounds = new RowBounds(offset,limit);
			
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList",cri,rowBounds);
		return memberList;
		}catch(Exception e) {
			throw e;
		}finally {
			if(session != null)session.close();
		}
	}



//	@Override
//	public void findMemId(SqlSession session, String memId) throws SQLException {
//		session.update("Member-Mapper.findMemId", memId);
//		
//	}

}