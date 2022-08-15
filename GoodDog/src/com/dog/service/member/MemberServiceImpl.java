package com.dog.service.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dog.dao.member.MemberDAO;
import com.dog.exception.InvalidPasswordException;
import com.dog.exception.NotFoundIDException;
import com.dog.vo.member.MemberVO;





public class MemberServiceImpl implements MemberService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void login(String memId, String memPw) throws SQLException, NotFoundIDException, InvalidPasswordException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MemberVO member = memberDAO.selectMemberById(session, memId);
			if (member == null) 
				throw new NotFoundIDException();
			if (!memPw.equals(member.getMemPw()))
				throw new InvalidPasswordException();
		} finally {
			session.close();
		}
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MemberVO member = memberDAO.selectMemberById(session, id);
			return member;
		} finally {
			session.close();
		}
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<MemberVO> memberList = memberDAO.selectMemberList(session);
			return memberList;
		} finally {
			session.close();
		}
	}


	@Override
	public void regist(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			memberDAO.insertMember(session, member);
		} finally {
			session.close();
		}
	}

	@Override
	public void modify(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			memberDAO.updateMember(session, member);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			memberDAO.deleteMember(session, id);
		} finally {
			session.close();
		}
		
	}

	@Override
	public void disabled(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			memberDAO.disabledMember(session, id);
		} finally {
			session.close();
		}
	}

	@Override
	public void enabled(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			memberDAO.enabledMember(session, id);
		} finally {
			session.close();
		}
		
	}

}