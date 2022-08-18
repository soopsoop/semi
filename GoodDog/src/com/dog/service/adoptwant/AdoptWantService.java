package com.dog.service.adoptwant;

import java.sql.SQLException;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.dto.adoptwant.AdoptWantVO;
import com.dog.dto.happydog.DogVO;

public interface AdoptWantService {
	
	Map<String, Object> getAdoptWantList(Criteria cri) throws SQLException;
	
	public void regist(AdoptWantVO want) throws Exception;
	
	AdoptWantVO getAdoptWant(String wantNo) throws SQLException;	
	
	public void modify(AdoptWantVO want) throws Exception;
	
	public void remove(String wantNo) throws Exception; 
	
}
