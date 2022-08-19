package com.dog.service.report;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dog.command.Criteria;
import com.dog.command.PageMaker;
import com.dog.dao.report.ReportDAO;
import com.dog.dto.member.MemberVO;
import com.dog.dto.report.ReportVO;

public class ReportServiceImpl implements ReportService {
	
	private ReportDAO reportDAO;
	public void setReportDAO(ReportDAO reportDAO) {
		this.reportDAO = reportDAO;
	}

	@Override
	public Map<String, Object> getReportList(Criteria cri) throws SQLException {
		Map<String, Object> dataMap = null;
		
		List<ReportVO> reportList = reportDAO.selectReportList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(reportDAO.selectReportListCount(cri));
		
		dataMap = new HashMap<String, Object>();
		dataMap.put("reportList", reportList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}


	@Override
	public int selectReportListCount(Criteria cri) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


//	@Override
//	public ReportVO selectReportByNo(String reportNo) throws SQLException {
//		ReportVO report = reportDAO.selectReportByNo(reportNo);
//		return report;
//	}
	
	@Override
	public void insertReport(ReportVO report) throws SQLException {
		System.out.println(report.getReportNo());
		System.out.println(report.getReportTitle());
		System.out.println(report.getReportType());
		System.out.println(report.getReportBreed());
		System.out.println(report.getReportGender());
		System.out.println(report.getReportPlace());
		System.out.println(report.getReportFeature());
		System.out.println(report.getReportPic());
		System.out.println(report.getFoundDate());
		System.out.println(report.getReportDate());
		System.out.println(report.getMemId());
		
		reportDAO.insertReport(report);

	}

	@Override
	public void updateReport(ReportVO report) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteReport(String reportNo) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ReportVO getReport(String reportNo) throws SQLException {
		ReportVO report = reportDAO.selectReportByNo(reportNo);
		return report;
	}


}
