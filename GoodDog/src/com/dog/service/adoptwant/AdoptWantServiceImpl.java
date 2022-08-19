package com.dog.service.adoptwant;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.command.PageMaker;
import com.dog.dao.adoptwant.AdoptWantDAO;
import com.dog.dao.happydog.DogDAO;
import com.dog.dto.adoptwant.AdoptWantVO;
import com.dog.dto.happydog.DogVO;

public class AdoptWantServiceImpl implements AdoptWantService {

	private AdoptWantDAO adoptWantDao;
	
	public void setAdoptWantDAO(AdoptWantDAO adoptWantDao) {
		this.adoptWantDao = adoptWantDao;
	}
	
	
	@Override
	public Map<String, Object> getAdoptWantList(Criteria cri) throws SQLException {
		Map<String, Object> dataMap = null;

		List<AdoptWantVO> adoptWantList = adoptWantDao.selectAdoptWantList(cri);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adoptWantDao.selectAdoptWantListCount(cri));

		dataMap = new HashMap<String, Object>();
		dataMap.put("adoptWantList", adoptWantList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}
	

	@Override
	public void regist(AdoptWantVO want) throws Exception {
		adoptWantDao.insertAdoptWant(want);
	}

	@Override
	public AdoptWantVO getAdoptWant(String wantNo) throws SQLException {
		AdoptWantVO want = adoptWantDao.selectAdoptWantByNo(wantNo);
		return want;
	}

	@Override
	public void modify(AdoptWantVO want) throws Exception {
		adoptWantDao.updateAdoptWant(want);
		
	}

	@Override
	public void remove(String wantNo) throws Exception {
		adoptWantDao.deleteAdoptWant(wantNo);
		
	}

	

}
