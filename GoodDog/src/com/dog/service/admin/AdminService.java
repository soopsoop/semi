package com.dog.service.admin;


import java.sql.SQLException;

import com.dog.exception.InvalidPasswordException;
import com.dog.exception.NotFoundIDException;
import com.dog.vo.admin.AdminVO;



	public interface AdminService {
		
		// 로그인
		void login(String adminId, String adminPw) throws SQLException,NotFoundIDException, InvalidPasswordException;

		AdminVO getAdmin(String adminId) throws SQLException;
}
