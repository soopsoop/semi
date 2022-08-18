package com.dog.action.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dog.action.Action;
import com.dog.service.report.ReportService;
import com.dog.dto.report.ReportVO;

public class ReportDetailAction implements Action {
	
	private ReportService reportService;
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/report/reportDetail";
		
		String reportNo = request.getParameter("reportNo");
		System.out.println(reportNo);
		
		try {
			
			ReportVO report = reportService.getReport(reportNo);
			
			request.setAttribute("report", report);
			
		} catch (Exception e) {
			e.printStackTrace();
			// ........
			url = "/report/reportDetail_fail";
		}
		
		return url;
	}

}
