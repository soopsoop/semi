package com.dog.dao.volunteer;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.dog.vo.member.MemberVO;
import com.dog.vo.volunteer.VolunteerVO;

public class VolunteerDAOImpl implements VolunteerDAO {
	
	private SqlSessionFactory sqlSessionFactory;	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<MemberVO> selectVolunteerList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertVol(VolunteerVO volVo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertVolWantMember(String memId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
