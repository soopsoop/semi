package com.dog.dao.adoptwant;

import java.sql.SQLException;
import java.util.List;

import com.dog.command.Criteria;
import com.dog.dto.adoptwant.AdoptWantVO;
import com.dog.dto.happydog.DogVO;

public interface AdoptWantDAO {
	
	public List<AdoptWantVO> selectAdoptWantList(Criteria cri) throws SQLException;
	
	public int selectAdoptWantListCount(Criteria cri) throws SQLException;
	
	public AdoptWantVO selectAdoptWantByNo(String wantNo)throws SQLException;

	public void insertAdoptWant(AdoptWantVO want) throws SQLException;

	public void updateAdoptWant(AdoptWantVO want) throws SQLException;
	
	public void deleteAdoptWant(String wantNo) throws SQLException;

}	
