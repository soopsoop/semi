package com.dog.service.volunteer;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.command.PageMaker;
import com.dog.dao.volunteer.VolunteerDAO;
import com.dog.vo.member.MemberVO;
import com.dog.vo.volunteer.VolunteerVO;

public class VolunteerServiceImpl implements VolunteerService {
	
	private VolunteerDAO volunteerDAO;
	public void setVolunteerDAO(VolunteerDAO volunteerDAO) {
		this.volunteerDAO = volunteerDAO;
	}
	@Override
	public Map<String,Object> getVolWantMemberList(Criteria cri) throws SQLException {
		
		Map<String,Object> dataMap =null;
		
		//처리.......
		List<MemberVO> volunteerList = volunteerDAO.selectVolWantMemberList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(volunteerDAO.selectVolWantMemberListCount(cri));
		
		dataMap = new HashMap<String,Object>();
		dataMap.put("volunteerList", volunteerList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}
	
	@Override
	public void insertVol(VolunteerVO volVo) throws SQLException {
		volunteerDAO.insertVol(volVo);
		
	}

	@Override
	public void insertVolWantMember(String memId) throws SQLException {
		volunteerDAO.insertVolWantMember(memId);
	}

}
