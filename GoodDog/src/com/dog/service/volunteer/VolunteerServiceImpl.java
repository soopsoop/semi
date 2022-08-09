package com.dog.service.volunteer;

import java.sql.SQLException;
import java.util.List;

import com.dog.dao.volunteer.VolunteerDAO;
import com.dog.vo.member.MemberVO;
import com.dog.vo.volunteer.VolunteerVO;

public class VolunteerServiceImpl implements VolunteerService {
	
	private VolunteerDAO volunteerDAO;
	public void setVolunteerDAO(VolunteerDAO volunteerDAO) {
		this.volunteerDAO = volunteerDAO;
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
