package com.board.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dog.dto.member.MemberVO;



public class TestOracleMyBatisSqlSessionFactory {
	
	private SqlSessionFactory factory = new OracleMyBatisSqlSessionFactory();
	private SqlSession session;
	
	@Before
	public void openSession() {
		session = factory.openSession();
	}
	
	@Test
	public void testSqlSession () throws Exception {
		Assert.assertNotNull(session.getConnection());
	}
	
	@Test
	public void testSQL() {
		MemberVO menu = session.selectOne("Member-Mapper.selectMemberById", "asd");
		Assert.assertEquals("회원목록", menu.getMemAddr());
	}
	
	@After
	public void closeSession() {
		session.close();
	}
}