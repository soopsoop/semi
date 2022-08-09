package com.dog.dao.happydog;

import java.sql.SQLException;
import java.util.List;

import com.dog.command.Criteria;
import com.dog.vo.happydog.DogVO;

public interface DogDAO {
	
	List<DogVO> selectDogList(Criteria cri) throws SQLException;
	
	int selectDogListCount(Criteria cri) throws SQLException;
//	
//	DogVO selectDogById(String id)throws SQLException;
//	
//	public void insertDog(DogVO member) throws SQLException;
//	
//	public void updateDog(DogVO member) throws SQLException;
//	
//	void deleteDog(String dogNo) throws SQLException;

}	
