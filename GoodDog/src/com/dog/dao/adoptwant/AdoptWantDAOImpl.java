package com.dog.dao.adoptwant;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dog.command.Criteria;
import com.dog.dto.adoptwant.AdoptWantVO;
import com.dog.dto.happydog.DogVO;

public class AdoptWantDAOImpl implements AdoptWantDAO {
	
	private SqlSessionFactory sqlSessionFactory;	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<AdoptWantVO> selectAdoptWantList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int offset = cri.getStartRowNum();
			int limit = cri.getPerPageNum();
			RowBounds rowBounds = new RowBounds(offset,limit);
			
			List<AdoptWantVO> AdoptWantList 
			= session.selectList("AdoptWant-Mapper.selectAdoptWantList", cri, rowBounds);
			
			return AdoptWantList;
			
		} catch(Exception e) {
			throw e;
		} finally {
			if(session != null) session.close();
		}
	}

	@Override
	public int selectAdoptWantListCount(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int count = session.selectOne("AdoptWant-Mapper.selectAdoptWantListCount", cri);
			
			return count;
			
		} catch(Exception e) {
			throw e;
		} finally {
			if(session != null) session.close();
		}
	}

	@Override
	public AdoptWantVO selectAdoptWantByNo(String wantNo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {			  
			AdoptWantVO want=session.selectOne("AdoptWant-Mapper.selectAdoptWantByNo", wantNo);			
			return want;			
		}catch(Exception e) {
			throw e;
		}finally {
			if(session != null)session.close();
		}
	}

	@Override
	public void insertAdoptWant(AdoptWantVO want) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {			  
			session.update("AdoptWant-Mapper.insertAdoptWant", want);
		}catch(Exception e) {
			throw e;
		}finally {
			if(session != null) session.close();
		}
	}

	@Override
	public void updateAdoptWant(AdoptWantVO want) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {			  
			session.update("AdoptWant-Mapper.updateAdoptWant", want);
		} catch (Exception e) {
			throw e;
		} finally {
			if(session != null)session.close();
		}
		
	}

	@Override
	public void deleteAdoptWant(String wantNo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {			  
			session.update("AdoptWant-Mapper.deleteAdoptWant", wantNo);
		} catch (Exception e) {
			throw e;
		} finally {
			if(session != null)session.close();
		}
	}
		
	}
	




