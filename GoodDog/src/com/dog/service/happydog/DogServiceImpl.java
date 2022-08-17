package com.dog.service.happydog;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.command.PageMaker;
import com.dog.dao.happydog.DogDAO;
import com.dog.dto.happydog.DogVO;

public class DogServiceImpl implements DogService {

	private DogDAO dogDAO;

	public void setDogDAO(DogDAO dogDAO) {
		this.dogDAO = dogDAO;
	}

	@Override
	public Map<String, Object> getDogList(Criteria cri) throws SQLException {
		Map<String, Object> dataMap = null;

		List<DogVO> dogList = dogDAO.selectDogList(cri);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dogDAO.selectDogListCount(cri));

		dataMap = new HashMap<String, Object>();
		dataMap.put("dogList", dogList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public void regist(DogVO dog) throws Exception {
		dogDAO.insertDog(dog);
	}

	@Override
	public DogVO getDog(String dogNo) throws SQLException {
		DogVO dog = dogDAO.selectDogByNo(dogNo);
		return dog;
	}

	@Override
	public void modify(DogVO dog) throws Exception {
		dogDAO.updateDog(dog);
	}

	@Override
	public void remove(String dogNo) throws Exception {
		dogDAO.deleteDog(dogNo);
	}

}
