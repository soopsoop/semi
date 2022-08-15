package com.dog.dao.admin;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.dog.vo.admin.AdminVO;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public AdminVO selectAdminById(SqlSession session, String adminId) throws SQLException {
		AdminVO admin = session.selectOne("AdminMapper.selectAdminById", adminId);		
		return admin;
	}

}
