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

//	@Override
//	public List<MemberVO> selectVolunteerList() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String insertVol(VolunteerVO volVo) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String insertVolWantMember(String memId) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<VolunteerVO> selectVolList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
			
		try {
			int offset = cri.getStartRowNum();
			int limit = cri.getPerPageNum();
			RowBounds rowBounds = new RowBounds(offset,limit);
			
			List<VolunteerVO> volList = session.selectList("Vol-Mapper.selectVolList", cri, rowBounds);
			
			return volList;
		} catch (Exception e) {
			throw e;
		} finally {
			if(session != null)session.close();
		}
		
	}

	@Override
	public int selectVolListCount(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int count = session.selectOne("Vol-Mapper.selectVolListCount", cri);
			return count;
		} catch (Exception e) {
			throw e;
		} finally {
			if(session != null)session.close();
		}
	}

}
