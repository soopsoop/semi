package com.dog.service.admin;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dog.dao.admin.AdminDAO;
import com.dog.dto.admin.AdminVO;
import com.dog.exception.InvalidPasswordException;
import com.dog.exception.NotFoundIDException;


public class AdminServiceImpl implements AdminService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	

	private AdminDAO adminDAO;
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	
	@Override
	public void login(String adminId, String adminPw) throws SQLException, NotFoundIDException, InvalidPasswordException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			AdminVO admin = adminDAO.selectAdminById(session, adminId);
			if (admin == null) 
				throw new NotFoundIDException();
			if (!adminPw.equals(admin.getAdminPw()))
				throw new InvalidPasswordException();
		} finally {
			session.close();
		}
	}

	@Override
	public AdminVO getAdmin(String adminId) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			AdminVO admin = adminDAO.selectAdminById(session, adminId);
			return admin;
		} finally {
			session.close();
		}
	}
}
