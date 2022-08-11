package com.dog.dao.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dog.command.Criteria;
import com.dog.vo.member.MemberVO;



public class MemberDAOImpl implements MemberDAO {
	
	private SqlSessionFactory SqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.SqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public MemberVO selectMemberById(String memId) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			MemberVO member = session.selectOne("Member-Mapper.selectMemberById", memId);
			return member;			
		}catch(Exception e) {
			throw e;
		}finally {
			if(session != null)session.close();
		}
	}
	
	public int selectMemberListCount(Criteria cri) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {
			
			int count = session.selectOne("Member-Mapper.selectMemberListCount",cri);			
			return count;
		}catch(Exception e) {
			//俊矾贸府
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


	@Override
	public void insertMember(MemberVO member) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {			  
			session.update("Member-Mapper.insertMember",member);
		}catch(Exception e) {
			//俊矾贸府
			throw e;
		}finally {
			if(session != null)session.close();
		}
		
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {			  
			session.update("Member-Mapper.updateMember",member);
		}catch(Exception e) {
			//俊矾贸府
			throw e;
		}finally {
			if(session != null)session.close();
		}
		
	}

	@Override
	public void deleteMember(String memId) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession();
		try {			  
			session.update("Member-Mapper.deleteMember",memId);	
		}catch(Exception e) {
			//俊矾贸府
			throw e;
		}finally {
			if(session != null)session.close();
		}
	}

//	@Override
//	public void disabledMember(SqlSession session, String id) throws SQLException {
//		session.update("Member-Mapper.disabledMember", id);
//	}
//
//	@Override
//	public void enabledMember(SqlSession session, String id) throws SQLException {
//		session.update("Member-Mapper.enabledMember", id);
//	}

}