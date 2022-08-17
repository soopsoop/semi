package com.dog.service.volunteer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.dog.command.Criteria;
<<<<<<< HEAD
import com.dog.dto.volunteer.VolunteerVO;

=======
import com.dog.dto.member.MemberVO;
import com.dog.dto.volunteer.VolunteerVO;
s
public interface VolunteerService {
	
	//회원목록조회
	Map<String,Object> getVolWantMemberList(Criteria cri)throws SQLException;
	
	public void insertVol(VolunteerVO volVo) throws SQLException;
	
	public void insertVolWantMember(String memId) throws SQLException;
	
	public Map<String, Object> getVolList(Criteria cri) throws SQLException;
	
	//봉사상세조회
	VolunteerVO getVolunteer(String volTitle)throws SQLException;	
	
}
