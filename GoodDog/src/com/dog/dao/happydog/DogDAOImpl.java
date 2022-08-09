package com.dog.dao.happydog;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dog.command.Criteria;
import com.dog.vo.happydog.DogVO;

public class DogDAOImpl implements DogDAO {
	
	private SqlSessionFactory sqlSessionFactory;	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<DogVO> selectDogList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int offset = cri.getStartRowNum();
			int limit = cri.getPerPageNum();
			RowBounds rowBounds = new RowBounds(offset,limit);
			
			List<DogVO> dogList 
			= session.selectList("Dog-Mapper.selectDogList", cri, rowBounds);
			
			return dogList;
			
		} catch(Exception e) {
			throw e;
		} finally {
			if(session != null) session.close();
		}
	}

	@Override
	public int selectDogListCount(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int count = session.selectOne("Dog-Mapper.selectDogListCount", cri);
			
			return count;
			
		} catch(Exception e) {
			throw e;
		} finally {
			if(session != null) session.close();
		}
	}
}
