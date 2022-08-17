package com.dog.dao.admin;

import java.sql.SQLException;


import org.apache.ibatis.session.SqlSession;

import com.dog.dto.admin.AdminVO;



public interface AdminDAO {
	

	AdminVO selectAdminById(SqlSession session, String adminId) throws SQLException;

	
}