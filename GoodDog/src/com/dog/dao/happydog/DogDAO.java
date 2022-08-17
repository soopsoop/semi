package com.dog.dao.happydog;

import java.sql.SQLException;
import java.util.List;

import com.dog.command.Criteria;
import com.dog.dto.happydog.DogVO;

public interface DogDAO {
	
	public List<DogVO> selectDogList(Criteria cri) throws SQLException;
	
	public int selectDogListCount(Criteria cri) throws SQLException;
	
	public DogVO selectDogByNo(String dogNo)throws SQLException;

	public void insertDog(DogVO dog) throws SQLException;

	public void updateDog(DogVO dog) throws SQLException;
	
	public void deleteDog(String dogNo) throws SQLException;

}	
