package com.dog.dao.volunteer;

import java.sql.SQLException;
import java.util.List;

import com.dog.command.Criteria;
import com.dog.vo.member.MemberVO;
import com.dog.vo.volunteer.VolunteerVO;

public interface VolunteerDAO {
//	public List<MemberVO> selectVolunteerList() throws SQLException; // 봉사 신청자 현황
	
//	public String insertVol(VolunteerVO volVo) throws SQLException; // 봉사 등록
	
//	public String insertVolWantMember(String memId) throws SQLException; // 신청자 등록
	

	List<VolunteerVO> selectVolList(Criteria cri) throws SQLException;
	int selectVolListCount(Criteria cri) throws SQLException;

	
}
