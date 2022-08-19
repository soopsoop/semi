package com.dog.dao.report;

import java.sql.SQLException;
import java.util.List;

import com.dog.command.Criteria;
import com.dog.dto.member.MemberVO;
import com.dog.dto.report.ReportVO;

public interface ReportDAO {
	
	List<ReportVO> selectReportList(Criteria cri) throws SQLException;
	int selectReportListCount(Criteria cri) throws SQLException;
	
	ReportVO selectReportByNo(String reportNo) throws SQLException;
	
	// 제보 추가
	public void insertReport(ReportVO report) throws SQLException;
	
	// 제보 수정
	public void updateReport(ReportVO report) throws SQLException;
	
	// 제보 삭제
	void deleteReport(int reportNo) throws SQLException;
	
	
	
	

}
