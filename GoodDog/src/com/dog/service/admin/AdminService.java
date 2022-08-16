package com.dog.service.admin;


import java.sql.SQLException;

import com.dog.dto.admin.AdminVO;
import com.dog.exception.InvalidPasswordException;
import com.dog.exception.NotFoundIDException;



	public interface AdminService {
		
		// 로그인
		void login(String adminId, String adminPw) throws SQLException,NotFoundIDException, InvalidPasswordException;

		AdminVO getAdmin(String adminId) throws SQLException;
}
