package com.dog.dao.report;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dog.command.Criteria;
import com.dog.dto.member.MemberVO;
import com.dog.dto.report.ReportVO;

public class ReportDAOImpl implements ReportDAO {
	
	private SqlSessionFactory sqlSessionFactory;	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<ReportVO> selectReportList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			int offset = cri.getStartRowNum();
			int limit = cri.getPerPageNum();
			RowBounds rowBounds = new RowBounds(offset,limit);
			
			List<ReportVO> reportList 
				= session.selectList("Report-Mapper.selectReportList", cri, rowBounds);
			
			return reportList;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if(session != null)session.close();
		}
	}

	@Override
	public int selectReportListCount(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			int count = session.selectOne("Report-Mapper.selectReportListCount",cri);			
			return count;
		}catch(Exception e) {
			//에러처리
			throw e;
		}finally {
			if(session != null)session.close();
		}
	}

	@Override
	public ReportVO selectReportByNo(String reportNo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {			  
			ReportVO report=session.selectOne("Report-Mapper.selectReportByNo",reportNo);			
			return report;			
		}catch(Exception e) {
			//에러처리
			throw e;
		}finally {
			if(session != null)session.close();
		}
	}

	@Override
	public void insertReport(ReportVO report) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Report-Mapper.insertReport", report);
		} catch (Exception e) {
			
			throw e;
		} finally {
			if (session != null) session.close();
		}
		
	}

	@Override
	public void updateReport(ReportVO report) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteReport(int reportNo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
