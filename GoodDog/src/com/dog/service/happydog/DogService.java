package com.dog.service.happydog;

import java.sql.SQLException;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.vo.happydog.DogVO;

public interface DogService {
	
	Map<String, Object> getDogList(Criteria cri) throws SQLException;
	
//	DogVO getDog(String dogNo) throws SQLException;	
//
//	public void regist(DogVO dog) throws Exception;
//	
//	public void modify(DogVO dog) throws Exception;
//	
//	public void remove(String dogNo) throws Exception; 
	
}
