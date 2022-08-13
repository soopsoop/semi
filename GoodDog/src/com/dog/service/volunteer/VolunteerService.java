package com.dog.service.volunteer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.vo.member.MemberVO;
import com.dog.vo.volunteer.VolunteerVO;

public interface VolunteerService {
	
	//회원목록조회
	Map<String,Object> getVolWantMemberList(Criteria cri)throws SQLException;
	
//	public List<MemberVO> selectVolunteerList() throws SQLException;
	
	public void insertVol(VolunteerVO volVo) throws SQLException;
	
	public void insertVolWantMember(String memId) throws SQLException;
}
