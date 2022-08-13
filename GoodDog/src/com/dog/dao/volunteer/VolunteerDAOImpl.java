package com.dog.dao.volunteer;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dog.command.Criteria;
import com.dog.vo.member.MemberVO;
import com.dog.vo.volunteer.VolunteerVO;

public class VolunteerDAOImpl implements VolunteerDAO {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<MemberVO> selectVolWantMemberList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int offset = cri.getStartRowNum();
			int limit = cri.getPerPageNum();
			RowBounds rowBounds = new RowBounds(offset, limit);

			List<MemberVO> VolWantMemberList = session.selectList("Volunteer-Mapper.selectVolWantMemberList", cri, rowBounds);

			return VolWantMemberList;
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public int selectVolWantMemberListCount(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			int count = session.selectOne("Volunteer-Mapper.selectVolWantMemberListCount",cri);			
			return count;
		}catch(Exception e) {
			//에러처리
			throw e;
		}finally {
			if(session != null)session.close();
		}
	}

	@Override
	public void insertVol(VolunteerVO volVo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("Volunteer-Mapper.inserVol", volVo);
		if (session != null)
			session.close();
	}

	@Override
	public void insertVolWantMember(String memId) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("Volunteer-Mapper.insertVolunteer", memId);
		if (session != null)
			session.close();
	}

}
