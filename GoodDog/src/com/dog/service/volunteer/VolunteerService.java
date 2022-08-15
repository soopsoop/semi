package com.dog.service.volunteer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.vo.member.MemberVO;
import com.dog.vo.volunteer.VolunteerVO;

public interface VolunteerService {
	public List<MemberVO> selectVolunteerList() throws SQLException;
	
	public String insertVol(VolunteerVO volVo) throws SQLException;
	
	public String insertVolWantMember(String memId) throws SQLException;
	
	public Map<String, Object> getVolList(Criteria cri) throws SQLException;
}
