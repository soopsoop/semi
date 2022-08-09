package com.dog.service.volunteer;

import java.sql.SQLException;
import java.util.List;

import com.dog.vo.member.MemberVO;
import com.dog.vo.volunteer.VolunteerVO;

public interface VolunteerService {
	public List<MemberVO> selectVolunteerList() throws SQLException;
	
	public String insertVol(VolunteerVO volVo) throws SQLException;
	
	public String insertVolWantMember(String memId) throws SQLException;
}
