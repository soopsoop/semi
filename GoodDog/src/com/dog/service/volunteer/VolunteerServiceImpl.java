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

	@Override
	public Map<String,Object> getVolList(Criteria cri) throws SQLException { //등록된 봉사 목록 조회
		Map<String, Object> dataMap = null;
		
		List<VolunteerVO> volList = volunteerDAO.selectVolList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(volunteerDAO.selectVolListCount(cri));
		
		dataMap = new HashMap<String, Object>();
		dataMap.put("volList", volList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

}
