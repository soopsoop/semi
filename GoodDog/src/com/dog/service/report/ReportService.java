package com.dog.service.report;

import java.sql.SQLException;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.dto.member.MemberVO;
import com.dog.dto.report.ReportVO;

public interface ReportService {
	
	Map<String,Object> getReportList(Criteria cri) throws SQLException;
	int selectReportListCount(Criteria cri) throws SQLException;
	
//	ReportVO selectReportByNo(String reportNo) throws SQLException;
	
	// 제보 추가
	public void insertReport(ReportVO report) throws SQLException;
	
	// 제보 수정
	public void updateReport(ReportVO report) throws SQLException;
	
	// 제보 삭제
	void deleteReport(String reportNo) throws SQLException;
	
	// 제보 상세 조회
	ReportVO getReport(String reportNo) throws SQLException;
	
}
